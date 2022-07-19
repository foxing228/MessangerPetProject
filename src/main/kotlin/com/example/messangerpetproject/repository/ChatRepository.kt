package messanger.project.repository

import messanger.project.model.Chat
import org.springframework.data.mongodb.repository.MongoRepository

interface ChatRepository: MongoRepository<Chat, String> {

    fun findByName(name: Chat): Chat

}