package com.example.wahtsapp.presentation.ui.home.model

import androidx.compose.runtime.Composable

data class BottomNavItem(
    val route: String,
    val icon: @Composable (Boolean) -> Unit,
    val label: String,
    val badgeCount: Int = 0
)