package ru.semi.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.semi.dto.LogInfo;
import ru.semi.services.interfaces.LoggerServiceConsumer;

@Service
public class LoggerServiceConsumerImpl implements LoggerServiceConsumer {

    @RabbitListener(queues = "log-queue")
    public void receiveLogData(String message) {
        // TODO: 30.11.2019 save into cassandra
    }

    @RabbitListener(queues = "error-log-queue")
    public void receiveErrorLogData(String message) {
        // TODO: 30.11.2019 save into elastic by index log-error
    }

    @RabbitListener(queues = "business-log-queue")
    public void receiveBusinessLogData(String message) {
        // TODO: 30.11.2019 save into elastic by index business-logic
    }



}
