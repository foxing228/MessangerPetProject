package com.example.messangerpetproject

import com.example.messangerpetproject.service.UserService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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
