package com.example.messangerpetproject.service

import com.example.messangerpetproject.model.Chat
import com.example.messangerpetproject.model.FullChat
import com.example.messangerpetproject.model.User
import org.springframework.stereotype.Service


interface ChatService {

    fun createChat(userIds: HashSet<String>): Chat
    fun deleteChat(name: Chat)

    fun addUserToTheChat(chat: Chat, user: User)

    fun deleteUserFromChat(chat: Chat, user: User)

    fun findAllChats(): List<Chat>

    fun getChatById(chatId: String): FullChat

}