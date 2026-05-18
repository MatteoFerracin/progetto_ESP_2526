package com.example.progetto_esp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//data class che rappresenta una sequenza, attributo per tenere traccia del numero di bottoni cliccati e attributo per la stringa che rappresenta la sequenza effetiva formattata con i caratteri separati tra loro con delle virgole
@Entity(tableName = "games_table")
data class Sequence(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "ElementsCounter") val elementsCounter: Int,
    @ColumnInfo(name = "Sequence") val lettersSequence: String
)


class GameViewModel(application: Application): AndroidViewModel(application){
    //sequenza di lettere attuale, inizialmente è una stringa vuota
    var actualSequence by mutableStateOf("")
        private set //in questo modo solamente il viewModel può modificarla direttamente

    //numero di tasti premuti nella sequenza attuale, inizialmente è 0
    var actualCounter by mutableIntStateOf(0)
        private set //in questo modo solo il viewModel può modificarla direttamente

    /*
    //lista che contiene le sequenza delle partite effettuate
    val gamesList = mutableStateListOf<Sequence>()
     */

    private val db = GameRoomDatabase.getDatabase(application)
    private val dao = db.gameDao()
    val allGames: LiveData<List<Sequence>> = dao.getAllGames()

    //funzione che aumenta (di 1) il conteggio dei bottoni colorati schiacciati nella stringa attuale e aggiunge alla sequenza la lettera corrispondente (passata come parametro) al colore cliccato (formattato in modo da separare le lettere tra di loro con delle virgole)
    fun addColor(letter: String){
        actualCounter++
        actualSequence += if(actualSequence.isEmpty()) letter
        else ", $letter"
    }

    //funzione che viene chiamata quando viene schiacciato il tasto "cancella", azzera il conteggio dei bottoni cliccati e cancella la sequenza attuale, non viene salvata nella lista
    fun deleteGame(){
        actualCounter = 0
        actualSequence = ""
    }

    //funzione che viene chiamata quando viene schiacciato il tasto "fine partita", salva la sequenza attuale nella lista e riazzera lo stato della sequenza attuale per poterne inserire una nuova
    fun endGame(){
        //se la sequenza non è vuota viene istanziato un oggetto di tipo Sequence e aggiunto alla lista per poter poi essere rappresentato nella seconda schermata
        if(!actualSequence.isEmpty()){
            val newSequence = Sequence(0,actualCounter, actualSequence)

            //l'ultima partita giocata viene inserita in testa in modo tale da mostrare le partite più recenti nella seconda schermata
            //gamesList.add(0, newSequence)
            viewModelScope.launch(Dispatchers.IO) {
                dao.insertGame(newSequence)
            }

            //azzeramento del conteggio e della sequenza attuale in attesa della prossima partita
            actualCounter = 0
            actualSequence = ""
        }
        //se non viene schiacciato nessun bottone colorato e viene terminata la partita (quindi con una stringa vuota) salviamo lo stesso la partita che avrà 0 come contatore dei tasti premuti e un carattere '/' come indicatore di stringa vuota, non è necessario riazzerare actualCounter e actualSequence perchè sono già azzerati
        else{
            val newSequence = Sequence(0,actualCounter, "/")

            //gamesList.add(0, newSequence)

            viewModelScope.launch(Dispatchers.IO) {
                dao.insertGame(newSequence)
            }
        }
    }

    fun getDetail(id: Int): LiveData<Sequence> {
        return dao.getGameById(id)
    }
}
