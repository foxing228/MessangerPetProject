package com.example.messangerpetproject.service

import com.example.messangerpetproject.model.User
import org.springframework.stereotype.Service


interface UserService {

    fun createUser(user: User)

    fun deleteUser(id: String)

    fun updateUser(user: User): User

    fun findUserByPhoneNumber(phoneNumber: String): User?

    fun findUserByUserName(name: String): User?

    fun findByUserId(id: String): User?
}