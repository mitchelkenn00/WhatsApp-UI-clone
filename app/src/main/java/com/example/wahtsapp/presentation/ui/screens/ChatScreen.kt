package com.example.wahtsapp.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wahtsapp.domain.model.Message
import com.example.wahtsapp.presentation.ui.components.ChatBubble
import com.example.wahtsapp.presentation.ui.components.ChatInputBar
import com.example.wahtsapp.presentation.theme.*
import com.example.wahtsapp.presentation.viewModel.ChatViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    chatId: String,
    chatViewModel: ChatViewModel = viewModel(),
    onNavigateBack: () -> Unit = {}
) {
    val messages by chatViewModel.messages.collectAsState()
    val messageText by chatViewModel.messageText.collectAsState()
    val chatName by chatViewModel.chatName.collectAsState()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(chatId) {
        chatViewModel.initChat(chatId)
    }

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            coroutineScope.launch {
                listState.animateScrollToItem(messages.size - 1)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ChatBackgroundLight)
    ) {
        TopAppBar(
            title = { Text(chatName, color = Neutral10) },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Neutral10)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = WhatsAppGreen
            )
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            state = listState,
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(messages) { message ->
                ChatBubble(message = message)
            }
        }

        ChatInputBar(
            messageText = messageText,
            onMessageTextChanged = chatViewModel::onMessageTextChanged,
            onSendMessage = chatViewModel::sendMessage
        )
    }
}
