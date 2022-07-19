package com.example.messangerpetproject.model

data class FullChat(
    val chat: Chat,
    val userList: List<User>,
    val messageList: List<Message>
)
