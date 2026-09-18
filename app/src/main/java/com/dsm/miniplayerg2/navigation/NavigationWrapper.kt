package com.dsm.miniplayerg2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dsm.miniplayerg2.ui.screens.home.HomeScreen
import com.dsm.miniplayerg2.ui.screens.initial.InitialScreen
import com.dsm.miniplayerg2.ui.screens.login.LoginScreen
import com.dsm.miniplayerg2.ui.screens.login.LoginViewModel
import com.dsm.miniplayerg2.ui.screens.signup.SignUpScreen
import com.dsm.miniplayerg2.ui.screens.signup.SignUpViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationWrapper(
    navHostController: NavHostController,
    auth: FirebaseAuth
) {
    val signUpViewModel: SignUpViewModel = koinViewModel()
    val loginViewModel: LoginViewModel = koinViewModel()

    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                onLogin={navHostController.navigate("logIn")},
                onSignUp={navHostController.navigate("signUp")}
            )
        }
        composable("logIn") {
            LoginScreen(
                loginViewModel,
                onSignUp={navHostController.navigate("signUp")},
                onHome={navHostController.navigate("home")}
            )
        }
        composable("signUp") {
            SignUpScreen(signUpViewModel,
                onLogin={navHostController.navigate("logIn")})
        }
        composable("home") {
            HomeScreen()
        }
    }
}