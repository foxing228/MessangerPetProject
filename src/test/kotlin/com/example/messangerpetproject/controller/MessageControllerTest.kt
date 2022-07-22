package com.example.messangerpetproject.controller

import com.example.messangerpetproject.model.Message
import com.example.messangerpetproject.model.User
import com.example.messangerpetproject.service.MessageService
import com.example.messangerpetproject.service.UserService
import org.bson.types.ObjectId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MessageControllerTest{

    @Autowired
    private lateinit var messageService: MessageService
    @Autowired
    private lateinit var restTemplate: TestRestTemplate
    private val id = ObjectId.get().toString()

    @LocalServerPort
    protected var port: Int = 0

    @Test
    fun `should update message`(){
        // val userToUpdate = userService.findByUserId("62d7e83144b291390f7d5439")
        val newMessage = Message(
            id = "62d94c418884b557daff2f45",
            datetime = LocalDateTime.now().toString(),
            text = "New text",
            messageChatId = "1",
            messageUserId = "62d68eaf0e586068f86005d3"
        )
        val updateResponse = restTemplate.exchange(
            "http://localhost:$port/message/messages-edit",
            HttpMethod.PUT,
            HttpEntity(newMessage, HttpHeaders()),
            Message::class.java
        )
        val messageAfterUpdate = messageService.findMessage("New text")

        assertEquals(listOf(newMessage), messageAfterUpdate)

    }


}