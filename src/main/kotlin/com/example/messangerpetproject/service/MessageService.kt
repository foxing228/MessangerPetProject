package com.example.messangerpetproject.service

import com.example.messangerpetproject.model.Message

interface MessageService {

    fun sendMessage(message: Message)

    fun deleteMessage(messageId: String)

    fun editMessage(message: Message): Message

    fun findMessage(text: String): List<Message?>
}