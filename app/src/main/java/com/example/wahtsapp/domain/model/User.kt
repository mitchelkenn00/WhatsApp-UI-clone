package com.example.wahtsapp.domain.model

data class User(
    val id: String,
    val name: String,
    val profilePictureUrl: String? = null
)
