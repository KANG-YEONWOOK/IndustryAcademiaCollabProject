package com.example.kumapp.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kumapp.R

@Composable
fun BottomBar(navController: NavController) {

    NavigationBar(containerColor = Color.White){
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        BottomBarList.BottomBarItems.forEach {

            val selectedColor =
                if(currentRoute == it.route) colorResource(id = R.color.kumiddlegreen)
                else colorResource(id = R.color.kudarkgreen)

            NavigationBarItem(selected = false,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(48.dp)
                            .padding(bottom=12.dp),
                        imageVector = it.icon,
                        contentDescription = stringResource(id = it.iconName),
                        tint = selectedColor
                    )
                },
                label={
                    Text(text = stringResource(id = it.iconName))
                }
            )
        }
    }

}