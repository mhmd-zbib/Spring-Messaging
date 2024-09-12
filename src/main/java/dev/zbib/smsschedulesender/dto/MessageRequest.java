package dev.zbib.smsschedulesender.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageRequest {
    String content;
}
