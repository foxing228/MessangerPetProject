package com.example.messangerpetproject

import messanger.project.repository.UserRepository
import messanger.project.service.Impl.UserServiceImpl
import messanger.project.service.UserService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MessangerPetProjectApplicationTests(
    private val userService: UserService
) {

//    @Test
//    fun contextLoads() {
//    }

    @BeforeEach
    fun init(){
        //val userService = UserServiceImpl()
    }

    @AfterEach
    fun afterEach(){

    }

    @Test
    fun `should find user by id`(){

    }

}
