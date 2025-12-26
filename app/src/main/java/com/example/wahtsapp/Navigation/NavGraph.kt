package com.example.wahtsapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wahtsapp.presentation.ui.screens.AuthScreen
import com.example.wahtsapp.presentation.ui.screens.ChatScreen
import com.example.wahtsapp.presentation.ui.screens.HomeScreen
import com.example.wahtsapp.presentation.ui.screens.ProfileScreen
import com.example.wahtsapp.presentation.ui.screens.StatusScreen

@Composable
fun WhatsAppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(
                onChatClick = { chatId ->
                    navController.navigate(Routes.Chat.createRoute(chatId))
                }
            )
        }
        
        composable(Routes.Chat.route) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            ChatScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Routes.Auth.route) {
            AuthScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Auth.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Routes.Profile.route) {
            ProfileScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Routes.Status.route) {
            StatusScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

