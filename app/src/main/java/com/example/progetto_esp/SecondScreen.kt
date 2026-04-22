package com.example.progetto_esp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen(viewModel: GameViewModel) {
    //non viene gestita la differenziazione tra modalità portrait e landscape perchè la disposizione degli elementi si adatta automaticamente in modo adeguato
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //stringa di testo informativa
        Text(
            text = stringResource(R.string.secondScreenMessage),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        //LazyColumn per rappresentare la lista che contiene le sequenze, in questa configurazione mostra l'elemento in testa alla coda in alto, ovvero per come è stata gestita la lista la partita più recente
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.gamesList) { game ->
                //row per separare la parte iniziale (20%) occupata dal numero di tasti premuti nella sequenza dalla parte successiva (80%) occupata dalla sequenza effettiva formattata con la separazione delle virgole tra una lettera e l'altra
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = game.elementsCounter.toString(),
                        modifier = Modifier.weight(0.2f)
                    )

                    Text(
                        text = game.lettersSequence,
                        maxLines = 1,
                        //una sequenza può occupare solamente una riga e se non è possibile che sia rappresentata completamente perchè troppo lunga avviene un troncamento indicato visualmente da tre puntini
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(0.8f)
                    )
                }
            }
        }
    }
}