package com.example.wahtsapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wahtsapp.domain.model.Chat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatListViewModel : ViewModel() {
    
    private val _chats = MutableStateFlow<List<Chat>>(emptyList())
    val chats: StateFlow<List<Chat>> = _chats.asStateFlow()
    
    init {
        loadSampleChats()
    }
    
    private fun loadSampleChats() {
        val sampleChats = listOf(
            Chat(
                id = "1",
                name = "vertiGO",
                lastMessage = "That's great! What kind of projects?",
                timestamp = System.currentTimeMillis() - 2400000,
                unreadCount = 2,
                isOnline = true
            ),
            Chat(
                id = "2",
                name = "Alice Johnson",
                lastMessage = "Hey, are you free for a call?",
                timestamp = System.currentTimeMillis() - 3600000,
                unreadCount = 1,
                isOnline = false
            ),
            Chat(
                id = "3",
                name = "Bob Smith",
                lastMessage = "Thanks for the help yesterday!",
                timestamp = System.currentTimeMillis() - 86400000,
                unreadCount = 0,
                isOnline = false
            ),
            Chat(
                id = "4",
                name = "Carol Davis",
                lastMessage = "Meeting at 3pm confirmed",
                timestamp = System.currentTimeMillis() - 172800000,
                unreadCount = 0,
                isOnline = true
            ),
            Chat(
                id = "5",
                name = "David Wilson",
                lastMessage = "Can you review the document?",
                timestamp = System.currentTimeMillis() - 259200000,
                unreadCount = 5,
                isOnline = false
            ),
            Chat(
                id = "6",
                name = "Emma Thompson",
                lastMessage = "See you tomorrow!",
                timestamp = System.currentTimeMillis() - 345600000,
                unreadCount = 0,
                isOnline = true
            ),
            Chat(
                id = "7",
                name = "Frank Miller",
                lastMessage = "The presentation went well",
                timestamp = System.currentTimeMillis() - 432000000,
                unreadCount = 1,
                isOnline = false
            ),
            Chat(
                id = "8",
                name = "Grace Lee",
                lastMessage = "Happy birthday! 🎉",
                timestamp = System.currentTimeMillis() - 518400000,
                unreadCount = 0,
                isOnline = false
            )
        )
        _chats.value = sampleChats
    }
    
    fun markChatAsRead(chatId: String) {
        viewModelScope.launch {
            _chats.value = _chats.value.map { chat ->
                if (chat.id == chatId) {
                    chat.copy(unreadCount = 0)
                } else {
                    chat
                }
            }
        }
    }
}
