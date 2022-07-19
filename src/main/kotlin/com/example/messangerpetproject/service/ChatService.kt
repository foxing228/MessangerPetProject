package messanger.project.service

import messanger.project.model.Chat
import messanger.project.model.User
import org.springframework.stereotype.Service

@Service
interface ChatService {

    fun createChat(userList: HashSet<User>): Chat
    fun deleteChat(name: Chat)

    fun addUserToTheChat(chat: Chat, user: User)

    fun deleteUserFromChat(chat: Chat, user: User)

    fun findAllChats(): List<Chat>



}