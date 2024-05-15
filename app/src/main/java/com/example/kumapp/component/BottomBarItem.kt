package com.example.kumapp.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kumapp.R

data class BottomBarItem(
    val icon: ImageVector,
    val route: String,
    val iconName: Int
)

object BottomBarList{
    val BottomBarItems = listOf(
        BottomBarItem(
            icon = Icons.Default.Menu,
            route = "Menu",
            iconName = R.string.Menu
        ),
        BottomBarItem(
            icon = Icons.Default.Shop,
            route = "EventPage",
            iconName = R.string.Eventpage
        ),
        BottomBarItem(
            icon = Icons.Default.ChildCare,
            route = "CharacterPage",
            iconName = R.string.CharacterPage
        ),
        BottomBarItem(
            icon = Icons.Default.SupervisorAccount,
            route = "Friend",
            iconName = R.string.Friend
        )
    )
}