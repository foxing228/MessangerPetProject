package com.example.messangerpetproject.controller

import com.example.messangerpetproject.model.User
import com.example.messangerpetproject.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
open class UserController(
    val userService: UserService
) {

    @GetMapping("/users-find/{id}")
    fun findByUserId(@PathVariable("id") id: String): User? {
        return userService.findByUserId(id)
    }

    @GetMapping("/users/by-phone/{phoneNumber}")
    fun findByPhoneNumber(@PathVariable("phoneNumber") phoneNumber: String): User? {
        return userService.findUserByPhoneNumber(phoneNumber)
    }

    @GetMapping("/users/by-name/{userName}")
    fun findByUserName(@PathVariable("userName") userName: String): User? {
        return userService.findUserByUserName(userName)
    }

    @PostMapping("/users-create")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User) {
        userService.createUser(user)
    }

    @PutMapping("/users-update")
    fun updateUser(@RequestBody user: User): User{
        return userService.updateUser(user)
    }

    @DeleteMapping("/users-delete/{id}")
    fun delete(@PathVariable("id") id: String) {
        userService.deleteUser(id)
    }

}