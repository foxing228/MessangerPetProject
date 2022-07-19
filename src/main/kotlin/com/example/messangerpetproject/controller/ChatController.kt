package com.example.messangerpetproject.controller

import com.example.messangerpetproject.model.Chat
import com.example.messangerpetproject.model.User
import com.example.messangerpetproject.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat")
class ChatController (
    private val chatService: ChatService
){

    @PostMapping("/chats-create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createChat(@RequestBody users: HashSet<String>) {
        chatService.createChat(users)
    }

    @PutMapping("/chats-add")
    fun addUserToTheChat(@RequestBody user: User, chat: Chat) {
        chatService.addUserToTheChat(chat, user)
    }

    @DeleteMapping("/chats/{name}")
    fun delete(@PathVariable("name") name: Chat) {
        chatService.deleteChat(name)
    }

    @GetMapping("/chats-all")
    @ResponseStatus(HttpStatus.FOUND)
    fun findAllChats(): List<Chat>{
        return chatService.findAllChats()
    }

    @DeleteMapping("/chats-delUser")
    fun deleteUserFromChat(@RequestBody chat: Chat, user: User){
        chatService.deleteUserFromChat(chat, user)
    }

    @GetMapping("/get-chat-id")
    fun getChatById(@RequestParam chatId: String){
        chatService.getChatById(chatId)
    }

}
