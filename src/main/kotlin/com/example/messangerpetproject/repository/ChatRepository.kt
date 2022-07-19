package com.example.messangerpetproject.repository

import com.example.messangerpetproject.model.Chat
import org.springframework.data.mongodb.repository.MongoRepository

interface ChatRepository: MongoRepository<Chat, String> {

    fun findByName(name: Chat): Chat

    fun getChatById(id: String): Chat?

}