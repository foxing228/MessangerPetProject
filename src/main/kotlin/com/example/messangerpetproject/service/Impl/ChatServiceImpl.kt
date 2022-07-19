package messanger.project.service.Impl

import messanger.project.model.Chat
import messanger.project.model.User
import org.springframework.beans.factory.annotation.Autowired
import messanger.project.repository.ChatRepository
import messanger.project.repository.UserRepository
import messanger.project.service.ChatService

class ChatServiceImpl(
    @Autowired
    val chatRepository: ChatRepository,
) : ChatService {
    override fun createChat(users: HashSet<User>): Chat {
        val chat: Chat = Chat()
        val set = HashSet(users)
        chat.users = set
        return chatRepository.save(chat)
    }

    override fun deleteChat(name: Chat) {
        val chat: Chat = chatRepository.findByName(name)
        chatRepository.delete(chat)
    }

    override fun addUserToTheChat(chat: Chat, user: User) {
        val usersAdd: HashSet<User> = chat.users
        usersAdd.add(user)
        chat.users = usersAdd
        chatRepository.save(chat)
    }


    override fun deleteUserFromChat(chat: Chat, user: User) {
        val usersUpdate: HashSet<User> = chat.users
        usersUpdate.remove(user)
        chat.users = usersUpdate
        chatRepository.save(chat)
    }


    override fun findAllChats(): List<Chat> {
        return chatRepository.findAll()
    }


}
