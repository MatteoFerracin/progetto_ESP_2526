package com.example.progetto_esp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.progetto_esp.ui.theme.Progetto_espTheme

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val config = LocalConfiguration.current
    val isLandscape = config.orientation == Configuration.ORIENTATION_LANDSCAPE

    if(isLandscape){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(modifier = Modifier.weight(3f).fillMaxHeight()) {
                // Riga 1 (Peso 1)
                Row(
                    modifier = Modifier.weight(1f).fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Riga 2 (Peso 1)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Riga 3 (Peso 1)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
            }

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
                    text = "questa è di prova",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().weight(1f)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.firstScreenBtn1))
                    }

                    Button(
                        onClick = { /*sviluppare*/ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.firstScreenBtn2))
                    }
                }
            }
        }
    }
    else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(modifier = Modifier.weight(3f).fillMaxSize()) {
                // Riga 1 (Peso 1)
                Row(
                    modifier = Modifier.weight(1f).fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Riga 2 (Peso 1)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Riga 3 (Peso 1)
                Row(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { /*sviluppare*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {}
                    Button(
                        onClick = { /*sviluppare*/ },
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
                text = "questa è di prova",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { /*sviluppare*/ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.firstScreenBtn1))
                }

                Button(
                    onClick = { /*sviluppare*/ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.firstScreenBtn2))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    Progetto_espTheme {
        FirstScreen()
    }
}