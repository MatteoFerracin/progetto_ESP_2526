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
import androidx.navigation.NavType
import androidx.navigation.navArgument
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
                        navController = navController, startDestination = "gameScreen",
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable("gameScreen"){
                            GameScreen(
                                viewModel = vm,
                                onDeleteClicked = { vm.deleteGame() },
                                onEndGameClicked = {
                                    vm.endGame()
                                    navController.navigate("sequenceListScreen")
                                }
                            )
                        }
                        composable("sequenceListScreen"){
                            SequenceListScreen(
                                viewModel = vm,
                                navController = navController
                            )
                        }
                        composable(
                            "sequenceDetailScreen/{id}",
                                    arguments = listOf(navArgument("id") { type = NavType.IntType})
                            ){ backStackEntry ->
                                val id = backStackEntry.arguments?.getInt("id") ?: 0
                                SequenceDetailScreen(
                                    id = id,
                                    viewModel = vm
                                )
                        }
                    }
                }
            }
        }
    }
}