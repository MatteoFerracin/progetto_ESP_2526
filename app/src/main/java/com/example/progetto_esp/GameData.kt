package com.example.progetto_esp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class Sequence(val elementsCounter: Int, val lettersSequence: String)

class GameViewModel: ViewModel(){
    var actualSequence by mutableStateOf("")
        private set //in questo modo solamente il viewModel può modificarla direttamente

    var actualCounter by mutableIntStateOf(0)
        private set //in questo modo solo il viewModel può modificarla direttamente

    val gamesList = mutableStateListOf<Sequence>()

    //funzione che aumenta il conteggio dei bottoni colorati schiacciati nella stringa attuale e aggiunge alla sequenza la lettera corrispondente al colore cliccato (formattato in modo da separare le lettere tra di loro con delle virgole)
    fun addColor(letter: String){
        actualCounter++
        actualSequence += if(actualSequence.isEmpty()) letter
        else ", $letter"
    }

    //funzione che viene chiamata quando viene schiacciato il tasto cancella che azzera la sequenza attuale senza salvarla
    fun deleteGame(){
        actualCounter = 0
        actualSequence = ""
    }

    //funzione che viene chiamata quando viene schiacciato il tasto "fine partita", salva la sequenza attuale nella lista e riazzera lo stato della sequenza attuale per poterne inserire una nuova
    fun endGame(){
        if(!actualSequence.isEmpty()){
            val newSequence = Sequence(actualCounter, actualSequence)

            gamesList.add(0, newSequence)

            actualCounter = 0
            actualSequence = ""
        }
    }
}