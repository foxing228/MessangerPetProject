package messanger.project.service

import messanger.project.model.User
import org.springframework.stereotype.Service

@Service
interface UserService {

    fun createUser(user: User)

    fun deleteUser(id: String)

    fun updateUser(user: User): User

    fun findUserByPhoneNumber(phoneNumber: String): User?

    fun findUserByUserName(name: String): User?

    fun findByUserId(id: String): User?
}