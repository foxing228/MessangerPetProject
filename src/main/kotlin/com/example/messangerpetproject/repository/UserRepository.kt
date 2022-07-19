package messanger.project.repository

import messanger.project.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {

    fun findByUserName(userName: String): User?

    fun findByPhoneNumber(phoneNumber: String): User?

    fun findByUserId(id: String): User
}