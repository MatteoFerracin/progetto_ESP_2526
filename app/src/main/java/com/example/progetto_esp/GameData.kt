package com.example.progetto_esp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//data class che rappresenta una sequenza, attributo per tenere traccia del numero di bottoni cliccati e attributo per la stringa che rappresenta la sequenza effetiva formattata con i caratteri separati tra loro con delle virgole
data class Sequence(val elementsCounter: Int, val lettersSequence: String)


class GameViewModel: ViewModel(){
    //sequenza di lettere attuale, inizialmente è una stringa vuota
    var actualSequence by mutableStateOf("")
        private set //in questo modo solamente il viewModel può modificarla direttamente

    //numero di tasti premuti nella sequenza attuale, inizialmente è 0
    var actualCounter by mutableIntStateOf(0)
        private set //in questo modo solo il viewModel può modificarla direttamente

    //lista che contiene le sequenza delle partite effettuate
    val gamesList = mutableStateListOf<Sequence>()

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
            val newSequence = Sequence(actualCounter, actualSequence)

            gamesList.add(0, newSequence)

            //azzeramento del conteggio e della sequenza attuale in attesa della prossima partita
            actualCounter = 0
            actualSequence = ""
        }
    }
}