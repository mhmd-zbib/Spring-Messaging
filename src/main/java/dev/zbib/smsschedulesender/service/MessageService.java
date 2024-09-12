package dev.zbib.smsschedulesender.service;

import dev.zbib.smsschedulesender.dto.MessageRequest;
import dev.zbib.smsschedulesender.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MessageService {

    Message sendMessage(MessageRequest messageRequest);

    Message getMessageById(Long id);

    Page<Message> getMessageByPage(Pageable pageable);

    void deleteMessageById(Long id);

    Message updateMessage(Long id, MessageRequest messageRequest);

}
