package com.example.wahtsapp.Navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Chat : Routes("chat/{chatId}") {
        fun createRoute(chatId: String) = "chat/$chatId"
    }
    object Auth : Routes("auth")
    object Profile : Routes("profile")
    object Status : Routes("status")
}

