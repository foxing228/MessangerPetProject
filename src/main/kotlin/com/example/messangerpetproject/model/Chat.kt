package com.example.messangerpetproject.model

import com.example.messangerpetproject.model.Message
import com.example.messangerpetproject.model.User
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.FieldType
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("chats")
data class Chat(
    @MongoId(value = FieldType.OBJECT_ID)
    var id: String? = null,
    var name: String? = null,
    var messageIds: List<String>? = null,
    var userIds: Set<String>? = null
) {



}
