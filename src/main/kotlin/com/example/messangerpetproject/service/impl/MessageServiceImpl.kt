package com.example.messangerpetproject.service.impl

import com.example.messangerpetproject.model.Message
import org.springframework.beans.factory.annotation.Autowired
import com.example.messangerpetproject.repository.MessageRepository
import com.example.messangerpetproject.service.MessageService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MessageServiceImpl(
    @Autowired
    val messageRepository: MessageRepository
): MessageService {


    override fun sendMessage(message: Message) {
        val messageSend: Message = Message(text = message.text,
            messageChatId = message.messageChatId,
            messageUserId = message.messageUserId,
            datetime = LocalDateTime.now().toString())
        messageRepository.save(messageSend)
    }

    override fun deleteMessage(messageId: String) {
        val message: Message = messageRepository.findMessageById(messageId)
        messageRepository.delete(message)
    }

    override fun editMessage(message: Message): Message {
        val messageUpdate: Message = messageRepository.findMessageById(message.id!!)
            .copy(text = message.text,
                datetime = message.datetime)
        return messageRepository.save(messageUpdate)
    }

    override fun findMessage(text: String): List<Message?> {
        return listOf(messageRepository.findMessageByText(text))
    }


}