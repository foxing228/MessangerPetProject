package com.example.messangerpetproject.service.impl

import com.example.messangerpetproject.model.Chat
import com.example.messangerpetproject.model.FullChat
import com.example.messangerpetproject.model.User
import org.springframework.beans.factory.annotation.Autowired
import com.example.messangerpetproject.repository.ChatRepository
import com.example.messangerpetproject.repository.MessageRepository
import com.example.messangerpetproject.repository.UserRepository
import com.example.messangerpetproject.service.ChatService
import org.springframework.stereotype.Service


@Service
class ChatServiceImpl(
    @Autowired
    val chatRepository: ChatRepository,
    @Autowired
    val userRepository: UserRepository?,
    val messageRepository: MessageRepository?
) : ChatService {
    override fun createChat(userIds: Set<String>): Chat {
        val chat: Chat = Chat()
        val set = HashSet(userIds)
        chat.userIds = set
        return chatRepository.save(chat)
    }

    override fun deleteChat(name: Chat) {
        val chat: Chat = chatRepository.findByName(name)
        chatRepository.delete(chat)
    }

    override fun addUserToTheChat(chat: Chat, user: User) {
        val usersAdd: HashSet<String> = chat.userIds as HashSet<String>
        usersAdd.add(user.id!!)
        chat.userIds = usersAdd
        chatRepository.save(chat)
    }


    override fun deleteUserFromChat(chat: Chat, user: User) {
        val usersUpdate: HashSet<String> = chat.userIds as HashSet<String>
        usersUpdate.remove(user.id)
        chat.userIds = usersUpdate
        chatRepository.save(chat)
    }


    override fun findAllChats(): List<Chat> {
        return chatRepository.findAll()
    }

    override fun getChatById(chatId: String): FullChat {
        val chat = chatRepository.getChatById(chatId)
        val userList = chat!!.userIds!!.map {
            userRepository!!.findById(it).get()
        }.toList()
        val messageList = chat.messageIds!!.map {
            messageRepository!!.findById(it).get()
        }.toList()

        return FullChat(chat, userList, messageList)
    }


}
