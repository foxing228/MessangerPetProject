package messanger.project.repository

import messanger.project.model.Message
import org.springframework.data.mongodb.repository.MongoRepository

interface MessageRepository: MongoRepository<Message, String> {

    fun findMessageById(id: String): Message

    fun findMessageByText(text: String): Message
}