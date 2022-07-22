package com.example.messangerpetproject.service.impl

import com.example.messangerpetproject.model.Chat
import com.example.messangerpetproject.model.Message
import com.example.messangerpetproject.repository.ChatRepository
import com.example.messangerpetproject.repository.MessageRepository
import com.example.messangerpetproject.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ChatServiceImplTest{

    @Mock
    private lateinit var chatRepository: ChatRepository
    @Mock
    private lateinit var  userRepository: UserRepository
    @Mock
    private lateinit var messageRepository: MessageRepository


    @InjectMocks
    private lateinit var chatService: ChatServiceImpl
    lateinit var chat: Chat

    @BeforeAll
    fun prepareTestData(){
        chat = Chat(
        name = "Anton/Oleksandr",
        messageIds = listOf("1", "2", "3"),
        userIds = setOf("62d68eaf0e586068f86005d3", "62d7e83144b291390f7d5439")
        )
    }

    @Test
    fun `should delete chat`(){
        Mockito.`when`(chatRepository.findByName(chat)).thenReturn(chat)
        chatService.deleteChat(chat)
        Mockito.verify(chatRepository, Mockito.times(1)).delete(chat)
    }

}