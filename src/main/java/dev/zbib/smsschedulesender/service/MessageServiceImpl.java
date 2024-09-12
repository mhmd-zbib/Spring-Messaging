package dev.zbib.smsschedulesender.service;

import dev.zbib.smsschedulesender.dto.MessageRequest;
import dev.zbib.smsschedulesender.model.Message;
import dev.zbib.smsschedulesender.repository.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public Message sendMessage(MessageRequest messageRequest) {
        Message message = Message.builder()
                .content(messageRequest.getContent())
                .build();
        System.out.println("New Message: " + message.getContent());
        return messageRepository.save(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Page<Message> getMessageByPage(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    @Override
    public void deleteMessageById(Long id) {
        Message message = getMessageById(id);
        messageRepository.delete(message);
    }

    @Override
    public Message updateMessage(Long id, MessageRequest messageRequest) {
        Message message = getMessageById(id);
        message.setContent(messageRequest.getContent());
        return messageRepository.save(message);
    }


    @Scheduled(fixedRate = 30000)
    public void scheduledMessage() {
        String code = generateCode();
        MessageRequest messageRequest = MessageRequest.builder()
                .content(code)
                .build();
        sendMessage(messageRequest);
    }

    public String generateCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
}
