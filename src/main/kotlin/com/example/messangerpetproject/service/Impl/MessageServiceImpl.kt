package messanger.project.service.Impl

import messanger.project.model.Message
import org.springframework.beans.factory.annotation.Autowired
import messanger.project.repository.MessageRepository
import messanger.project.service.MessageService
import java.time.LocalDateTime

class MessageServiceImpl(
    @Autowired
    val messageRepository: MessageRepository
): MessageService {


    override fun sendMessage(message: Message) {
        val messageSend: Message = Message()
        messageSend.text = message.text
        messageSend.messageChatId = message.messageChatId
        messageSend.messageUserId = message.messageUserId
        messageSend.datetime = LocalDateTime.now().toString()
        messageRepository.save(messageSend)
    }

    override fun deleteMessage(messageId: String) {
        val message: Message = messageRepository.findMessageById(messageId)
        messageRepository.delete(message)
    }

    override fun editMessage(message: Message): Message {
        val messageUpdate: Message = messageRepository.findMessageById(message.id)
        messageUpdate.text=message.text
        messageUpdate.datetime=message.datetime
        return messageRepository.save(messageUpdate)
    }

    override fun findMessage(text: String): List<Message?> {
        return listOf(messageRepository.findMessageByText(text))
    }


}