package com.example.kumapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            NavigationHost(navController = navController)
        }
    }
}