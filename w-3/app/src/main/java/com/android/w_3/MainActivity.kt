package com.android.w_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ){
                composable("login"){
                    LoginScreen(navController = navController)
                }
                composable("register"){
                    RegisterScreen(navController = navController)
                }
            }

        }

        /*
        LoginAndRegisterUITutorialTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                LoginScreen(modifier = Modifier.padding(innerPadding)) */

    }
}



