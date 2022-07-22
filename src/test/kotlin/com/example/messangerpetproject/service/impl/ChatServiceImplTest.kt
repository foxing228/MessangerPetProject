package com.example.messangerpetproject.service.impl

import com.example.messangerpetproject.model.Chat
import com.example.messangerpetproject.model.Message
import com.example.messangerpetproject.repository.ChatRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ChatServiceImplTest{

    @Mock
    private lateinit var chatRepository: ChatRepository

    @InjectMocks
    private lateinit var chatService: ChatServiceImpl
    lateinit var chat: Chat

    @BeforeAll
    fun prepareTestData(){
        chat = Chat()
    }

}