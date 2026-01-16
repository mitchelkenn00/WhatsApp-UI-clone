package com.example.wahtsapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wahtsapp.domain.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()
    
    private val _messageText = MutableStateFlow("")
    val messageText: StateFlow<String> = _messageText.asStateFlow()

    private val _chatName = MutableStateFlow("Chat")
    val chatName: StateFlow<String> = _chatName.asStateFlow()
    
    fun initChat(chatId: String) {
        // In a real app, this would fetch from a database/API
        val names = mapOf(
            "1" to "vertiGO Lewis",
            "2" to "Alice Kimani",
            "3" to "DJ Afro",
            "4" to "Meru Kianjai",
            "5" to "Mitchel Ndungu",
            "6" to "Kasongo Eehh",
            "7" to "Nameless Person",
            "8" to "vertiGO 0628"
        )
        _chatName.value = names[chatId] ?: "lewis Gitau"
        loadSampleMessages(chatId)
    }
    
    private fun loadSampleMessages(chatId: String) {
        // Logic can be extended here to load different samples per chatId
        val sampleMessages = listOf(
            Message(
                id = "1",
                text = "Hey! How are you?",
                timestamp = System.currentTimeMillis() - 3600000,
                isOutgoing = false,
                senderName = _chatName.value
            ),
            Message(
                id = "2",
                text = "I'm good! Just working on some projects.",
                timestamp = System.currentTimeMillis() - 3000000,
                isOutgoing = true
            ),
            Message(
                id = "3",
                text = "That's great! What kind of projects?",
                timestamp = System.currentTimeMillis() - 2400000,
                isOutgoing = false,
                senderName = _chatName.value
            )
        )
        _messages.value = sampleMessages
    }
    
    fun onMessageTextChanged(text: String) {
        _messageText.value = text
    }
    
    fun sendMessage() {
        if (_messageText.value.isBlank()) return
        
        val newMessage = Message(
            id = System.currentTimeMillis().toString(),
            text = _messageText.value.trim(),
            timestamp = System.currentTimeMillis(),
            isOutgoing = true
        )
        
        viewModelScope.launch {
            _messages.update { it + newMessage }
            _messageText.update { "" }
        }
    }
}

