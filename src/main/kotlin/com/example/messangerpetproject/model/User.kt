package messanger.project.model


import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("users")
data class User(
    @MongoId(value = FieldType.OBJECT_ID)
    val id: String,
    var name: String,
    var phoneNumber: String,
    var bio: String,

    val chat: List<Chat>,

    val message: List<Message>
)