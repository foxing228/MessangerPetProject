package messanger.project.service.Impl

import messanger.project.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import messanger.project.repository.UserRepository
import messanger.project.service.UserService


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
        val userToUpdate: User = userRepository.findByUserId(user.id)
        userToUpdate.name = user.name
        userToUpdate.phoneNumber = user.phoneNumber
        userToUpdate.bio = user.bio
        return userRepository.save(userToUpdate)
    }

    override fun findUserByPhoneNumber(phoneNumber: String): User? {
        return userRepository.findByPhoneNumber(phoneNumber)
    }


    override fun findUserByUserName(userName: String): User? {
        return userRepository.findByUserName(userName)
    }

    override fun findByUserId(id: String): User? {
        return userRepository.findById(id).orElseThrow { Exception() }
    }
}