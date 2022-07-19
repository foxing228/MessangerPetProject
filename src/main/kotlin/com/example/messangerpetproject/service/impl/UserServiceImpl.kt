package com.example.messangerpetproject.service.impl

import com.example.messangerpetproject.model.User
import org.springframework.beans.factory.annotation.Autowired
import com.example.messangerpetproject.repository.UserRepository
import com.example.messangerpetproject.service.UserService
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
    @Autowired
    val userRepository: UserRepository
): UserService
{
    override fun createUser(user: User) {
        userRepository.save(user)
    }

    override fun deleteUser(id: String) {
        val user: User? = findByUserId(id)
        userRepository.delete(user!!)
    }

    override fun updateUser(user: User): User {
        val userToUpdate: User = userRepository.findById(user.id!!).get()
            .copy(name = user.name,
                phoneNumber = user.phoneNumber,
                bio = user.bio)

        return userRepository.save(userToUpdate)
    }

    override fun findUserByPhoneNumber(phoneNumber: String): User? {
        return userRepository.findByPhoneNumber(phoneNumber)
    }


    override fun findUserByUserName(userName: String): User? {
        return userRepository.findByName(userName)
    }

    override fun findByUserId(id: String): User? {
        return userRepository.findById(id).orElseThrow { Exception() }
    }
}