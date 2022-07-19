package com.example.messangerpetproject.repository

import com.example.messangerpetproject.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {

    fun findByName(userName: String): User?

    fun findByPhoneNumber(phoneNumber: String): User?


}