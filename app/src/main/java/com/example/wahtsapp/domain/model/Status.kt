package com.example.wahtsapp.domain.model

data class Status(
    val id: String,
    val user: User,
    val imageUrl: String,
    val timestamp: Long,
    val isViewed: Boolean = false
)
