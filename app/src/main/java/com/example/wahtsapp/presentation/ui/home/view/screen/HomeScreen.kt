package com.example.wahtsapp.presentation.ui.home.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.wahtsapp.presentation.ui.home.view.components.BottomTabRow
import com.example.wahtsapp.presentation.ui.home.view.components.WhatsAppChatsTopBar


@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            WhatsAppChatsTopBar(
                onCameraClick = { /*TODO*/ },
                onMoreClick = { /*TODO*/ }
            )

        },
        bottomBar = {
            BottomTabRow(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            Text(text = "Home Screen")
        }
    }

}