package com.example.wahtsapp.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Status
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wahtsapp.presentation.ui.components.ChatItem
import com.example.wahtsapp.presentation.theme.*
import com.example.wahtsapp.presentation.viewModel.ChatListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    chatListViewModel: ChatListViewModel = viewModel(),
    onChatClick: (String) -> Unit = {}
) {
    val chats by chatListViewModel.chats.collectAsState()
    var selectedTab by remember { mutableStateOf(0) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral10)
    ) {
        TopAppBar(
            title = { Text("WhatsApp", color = Neutral10, fontWeight = FontWeight.Bold) },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.CameraAlt, contentDescription = "Camera", tint = Neutral10)
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, contentDescription = "Search", tint = Neutral10)
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Neutral10)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = WhatsAppGreen
            )
        )
        
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = WhatsAppGreen,
            contentColor = Neutral10
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("CHATS", fontSize = 12.sp) },
                icon = { Icon(Icons.Default.Chat, contentDescription = "Chats") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("STATUS", fontSize = 12.sp) },
                icon = { Icon(Icons.Default.Status, contentDescription = "Status") }
            )
            Tab(
                selected = selectedTab == 2,
                onClick = { selectedTab = 2 },
                text = { Text("CALLS", fontSize = 12.sp) },
                icon = { Icon(Icons.Default.CameraAlt, contentDescription = "Calls") }
            )
        }
        
        when (selectedTab) {
            0 -> ChatsList(chats = chats, onChatClick = onChatClick)
            1 -> StatusPlaceholder()
            2 -> CallsPlaceholder()
        }
    }
}

@Composable
private fun ChatsList(
    chats: List<com.example.wahtsapp.domain.model.Chat>,
    onChatClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(chats) { chat ->
            ChatItem(
                chat = chat,
                onChatClick = onChatClick
            )
        }
    }
}

@Composable
private fun StatusPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral15),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Status Screen\n(Coming Soon)",
            color = Neutral60,
            fontSize = 18.sp
        )
    }
}

@Composable
private fun CallsPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral15),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Calls Screen\n(Coming Soon)",
            color = Neutral60,
            fontSize = 18.sp
        )
    }
}

