package com.example.wahtsapp.presentation.ui.home.view.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.wahtsapp.presentation.ui.home.model.BottomNavItem
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomTabRow(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val navItems = listOf(
        BottomNavItem(
            route = "Chats",
            icon = { isSelected ->
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Chat,
                    contentDescription = "Chats",
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            },
            label = "Chats",
            badgeCount = 12
        ),
        BottomNavItem(
            route = "Updates",
            icon = { isSelected ->
                Icon(
                    imageVector = Icons.Default.Update,
                    contentDescription = "updates",
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            },
            label = "updates",
            badgeCount = 0
        ),
        BottomNavItem(
            route = "Communities",
            icon = { isSelected ->
                Icon(
                    imageVector = Icons.Default.Groups,
                    contentDescription = "communities",
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            },
            label = "Communities"
        ),
        BottomNavItem(
            route = "Calls",
            icon = { isSelected ->
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "calls",
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            },
            label = "Calls",
            badgeCount = 1
        ),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val tabs = listOf("Chats", "Status", "Calls")
        val context = LocalContext.current
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val currentRoute = currentDestination?.route

        navItems.forEach { item ->

            val isSelected = currentRoute == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    Toast.makeText(context, "Waiting for gift to navigate", Toast.LENGTH_SHORT).show()
                /*navController.navigate(item.route)*/ },
                icon = { item.icon(isSelected) },
                label = { Text(text = item.label) },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.background,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                )
            )
        }

    }
}

