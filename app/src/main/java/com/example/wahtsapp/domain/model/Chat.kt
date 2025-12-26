package com.example.wahtsapp.domain.model

data class Chat(
    val id: String,
    val name: String,
    val lastMessage: String,
    val timestamp: Long,
    val unreadCount: Int = 0,
    val isOnline: Boolean = false,
    val profileImageUrl: String? = null
)
