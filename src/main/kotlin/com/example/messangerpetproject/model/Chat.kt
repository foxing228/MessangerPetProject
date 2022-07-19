package messanger.project.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("chats")
data class Chat(
    @MongoId(value = FieldType.OBJECT_ID)
    val id: String = "",
    val name: String = "",
    val messages: List<Message> = emptyList(),
    var users: HashSet<User> = emptySet<User>() as HashSet<User>
) {

}
