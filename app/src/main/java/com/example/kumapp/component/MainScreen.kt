package com.example.kumapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.kumapp.MainActivityViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainActivityViewModel) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            NavigationHost(navController = navController, viewModel)
        }
    }
}