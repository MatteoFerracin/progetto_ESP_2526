package com.example.progetto_esp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.progetto_esp.ui.theme.Progetto_espTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Progetto_espTheme {
                val navController = rememberNavController()

                val vm: GameViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController, startDestination = "firstScreen",
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable("firstScreen"){
                            FirstScreen(
                                viewModel = vm,
                                onDeleteClicked = { vm.deleteGame() },
                                onEndGameClicked = {
                                    vm.endGame()
                                    navController.navigate("secondScreen")
                                }
                            )
                        }
                        composable("secondScreen"){
                            SecondScreen(
                                viewModel = vm
                                //
                            )
                        }
                    }

                }
            }
        }
    }
}