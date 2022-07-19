package com.example.messangerpetproject.model

import com.example.messangerpetproject.model.Message
import com.example.messangerpetproject.model.User
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("chats")
data class Chat(
    @MongoId(value = FieldType.OBJECT_ID)
    val id: String = "",
    val name: String = "",
    val messageIds: List<String> = emptyList(),
    var userIds: Set<String> = emptySet<String>() as HashSet<String>
) {

}
