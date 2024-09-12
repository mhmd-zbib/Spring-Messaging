package dev.zbib.smsschedulesender.repository;

import dev.zbib.smsschedulesender.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
