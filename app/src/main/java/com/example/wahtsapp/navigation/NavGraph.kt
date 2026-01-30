package com.example.wahtsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wahtsapp.presentation.ui.screens.*

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

        composable(
            route = Routes.Chat.route,
            arguments = listOf(
                navArgument("chatId") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            ChatScreen(
                chatId = chatId,
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