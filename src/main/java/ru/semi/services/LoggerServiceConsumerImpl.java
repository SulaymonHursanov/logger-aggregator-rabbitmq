package ru.semi.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.semi.dto.LogInfo;
import ru.semi.services.interfaces.LoggerServiceConsumer;

import static ru.semi.config.RabbitMQ.*;

@Service
public class LoggerServiceConsumerImpl implements LoggerServiceConsumer {

    @RabbitListener(queues = LOG_QUEUE)
    public void receiveLogData(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = ERROR_LOG_QUEUE)
    public void receiveErrorLogData(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = BUSINESS_LOGIC_LOG_QUEUE)
    public void receiveBusinessLogData(String message) {
        System.out.println(message);
    }



}
