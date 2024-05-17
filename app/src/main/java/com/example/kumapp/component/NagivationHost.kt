package com.example.kumapp.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kumapp.MainActivityViewModel


sealed class Routes(val route:String){
    object Home:Routes("Home")
    object Menu:Routes("Menu")
    object CharacterPage:Routes("CharacterPage")
    object EventPage:Routes("EventPage")
    object Friend:Routes("Friend")
}

@Composable
fun NavigationHost(navController: NavHostController, viewModel: MainActivityViewModel){
    NavHost(navController=navController, startDestination="Home"){
        composable(Routes.Home.route){
            HomeScreen(navController, viewModel)
        }
        composable(Routes.Menu.route){
            Menu(navController, viewModel)
        }
        composable(Routes.CharacterPage.route){
            CharacterPage(navController, viewModel)
        }
        composable(Routes.EventPage.route){
            EventPage(navController, viewModel)
        }
        composable(Routes.Friend.route){
            Friend(navController, viewModel)
        }
    }
}