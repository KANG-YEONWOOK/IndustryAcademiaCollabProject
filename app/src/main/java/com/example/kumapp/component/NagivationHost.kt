package com.example.kumapp.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class Routes(val route:String){
    object Home:Routes("Home")
    object Menu:Routes("Menu")
    object CharacterPage:Routes("CharacterPage")
    object EventPage:Routes("EventPage")
    object Friend:Routes("Friend")
}

@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController=navController, startDestination="Home"){
        composable(Routes.Home.route){
            HomeScreen(navController)
        }
        composable(Routes.Menu.route){
            Menu(navController)
        }
        composable(Routes.CharacterPage.route){
            CharacterPage(navController)
        }
        composable(Routes.EventPage.route){
            EventPage(navController)
        }
        composable(Routes.Friend.route){
            Friend(navController)
        }
    }
}