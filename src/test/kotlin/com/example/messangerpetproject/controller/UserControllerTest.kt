package com.example.messangerpetproject.controller

import com.example.messangerpetproject.model.User
import com.example.messangerpetproject.service.UserService
import com.example.messangerpetproject.service.impl.UserServiceImpl
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserControllerTest{

    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var restTemplate: TestRestTemplate
    private val id = ObjectId.get().toString()

    @LocalServerPort
    protected var port: Int = 0

    @Test
    fun `should update user`(){
       // val userToUpdate = userService.findByUserId("62d7e83144b291390f7d5439")
        val newUser = User(
            id = "62d7e83144b291390f7d5439",
            name = "Maxym",
            phoneNumber = "+380993847294",
            bio = "New bio",
            chat = emptyList(),
            message = emptyList()
            )
        val updateResponse = restTemplate.exchange(
            "http://localhost:$port/user/users-update",
            HttpMethod.PUT,
            HttpEntity(newUser, HttpHeaders()),
            User::class.java
        )
        val userAfterUpdate = userService.findByUserId("62d7e83144b291390f7d5439")

        assertEquals(newUser, userAfterUpdate)

    }

}