package com.example.progetto_esp

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(onDeleteClicked: () -> Unit, onEndGameClicked: () -> Unit, viewModel: GameViewModel) {
    val config = LocalConfiguration.current
    //per gestire il cambio di configurazione tra modalità portrait e landscape, ritorna true se ci troviamo in modalità landscape, false altrimenti
    val isLandscape = config.orientation == Configuration.ORIENTATION_LANDSCAPE

    //entra nell'if se ci troviamo in modalità landscape
    if(isLandscape){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            //matrice dei pulsanti colorati gestita attraveso una column composta da 3 row di ugual peso, in ogni riga troviamo due bottoni
            Column(modifier = Modifier.weight(3f).fillMaxHeight()) {
                //prima riga di bottoni (rosso e verde)
                Row(
                    modifier = Modifier.weight(1f).fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        //quando viene premuto un tasto colorato viene richiamata la funzione del viewModel la quale aggiorna la sequenza attuale aggiungendo la lettera corrispondente al colore passata come parametro
                        onClick = { viewModel.addColor("R") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { viewModel.addColor("G") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
                Spacer(modifier = Modifier.height(8.dp))
                //seconda riga di bottoni (blu e magenta)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { viewModel.addColor("B") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { viewModel.addColor("M") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
                Spacer(modifier = Modifier.height(8.dp))
                //terza riga di bottoni (giallo e ciano)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { viewModel.addColor("Y") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { viewModel.addColor("C") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
            }

            //altra column che si trova a destra della matrice di bottoni colorati che contiene due text (la seconda mostra la sequenza attuale aggiornandosi ad ogni bottone colorato premuto) e una row con i due pulsanti per cancellare la sequenza e per terminare la partita
            Column(
                modifier = Modifier.fillMaxHeight().weight(3f).padding(8.dp, 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.firstScreenMessage),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().weight(1f)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = viewModel.actualSequence,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    //se la sequenza è troppo lunga per apparire tutta sullo schermo è possibile scorrerci sopra orizzontalmente per vedere le parti nascoste
                    modifier = Modifier.fillMaxWidth().weight(1f).horizontalScroll(rememberScrollState())
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = onDeleteClicked,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.firstScreenBtn1))
                    }

                    Button(
                        onClick = onEndGameClicked,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.firstScreenBtn2))
                    }
                }
            }
        }
    }
    //se la modalità e portrait entra nell'else
    else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Column composta da 3 row di egual peso che formano la matrice dei bottoni colorati
            Column(modifier = Modifier.weight(3f).fillMaxSize()) {
                //prima riga di bottoni (rosso e verde)
                Row(
                    modifier = Modifier.weight(1f).fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        //quando viene premuto un tasto colorato viene richiamata la funzione del viewModel la quale aggiorna la sequenza attuale aggiungendo la lettera corrispondente al colore passata come parametro
                        onClick = { viewModel.addColor("R") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { viewModel.addColor("G") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.height(8.dp))

                //seconda riga di bottoni (blu e magenta)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { viewModel.addColor("B") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { viewModel.addColor("M") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.height(8.dp))

                //terza riga di bottoni (giallo e ciano)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { viewModel.addColor("Y") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { viewModel.addColor("C") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.firstScreenMessage),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = viewModel.actualSequence,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                //se la sequenza è troppo lunga per apparire completamente sullo schermo è possibile scorrerci sopra orizzontalmente per vedere le parti nascoste
                modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())
            )

            Spacer(modifier = Modifier.height(24.dp))

            //row con i due pulsanti per cancellare la sequenza attuale e per terminare la partita
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = onDeleteClicked,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.firstScreenBtn1))
                }

                Button(
                    onClick = onEndGameClicked,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.firstScreenBtn2))
                }
            }
        }
    }
}