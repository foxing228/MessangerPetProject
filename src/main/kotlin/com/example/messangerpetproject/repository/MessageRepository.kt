package com.example.messangerpetproject.repository

import com.example.messangerpetproject.model.Message
import org.springframework.data.mongodb.repository.MongoRepository

interface MessageRepository: MongoRepository<Message, String> {

    fun findMessageById(id: String): Message

    fun findMessageByText(text: String): Message
}