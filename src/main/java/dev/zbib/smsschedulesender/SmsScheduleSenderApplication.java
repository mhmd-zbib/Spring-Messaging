package dev.zbib.smsschedulesender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmsScheduleSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsScheduleSenderApplication.class, args);
    }

}
