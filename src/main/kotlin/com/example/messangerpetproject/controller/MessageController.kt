package com.example.messangerpetproject.controller

import com.example.messangerpetproject.model.Message
import com.example.messangerpetproject.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController(
    val messageService: MessageService
) {
    @PostMapping("/messages-create")
    @ResponseStatus(HttpStatus.CREATED)
    fun sendMessage(@RequestBody message: Message) {
        messageService.sendMessage(message)
    }

    @PutMapping("/messages-edit")
    fun editMessage(@RequestBody message: Message) {
        messageService.editMessage(message)
    }

    @DeleteMapping("/messages-delete/{id}")
    fun delete(@PathVariable("id") id: String) {
        messageService.deleteMessage(id)
    }



    @GetMapping("/messages/by-id/{text}")
    fun findMessage(@PathVariable("text") text: String): List<Message?> {
        return messageService.findMessage(text)
    }
}