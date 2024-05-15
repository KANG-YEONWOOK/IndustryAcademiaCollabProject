package com.example.kumapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.kumapp.component.Routes

@Composable
fun TopBar(navController: NavController) {
    Row(horizontalArrangement = Arrangement.Start) {
        IconButton(onClick={navController.navigate(Routes.Home.route){
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        } }){
            Icon(Icons.Default.ArrowBackIosNew,null)
        }
    }

}