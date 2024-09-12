package dev.zbib.smsschedulesender.controller;

import dev.zbib.smsschedulesender.dto.MessageRequest;
import dev.zbib.smsschedulesender.model.Message;
import dev.zbib.smsschedulesender.service.MessageService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Messager;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody MessageRequest messageRequest) {
        Message message = messageService.sendMessage(messageRequest);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<Page<Message>> getMessages(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Message> messageList = messageService.getMessageByPage(pageable);
        return ResponseEntity.ok(messageList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@RequestBody MessageRequest messageRequest, @PathVariable Long id) {
        Message message = messageService.updateMessage(id, messageRequest);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessageById(id);
        return ResponseEntity.ok("Message deleted");
    }

}
