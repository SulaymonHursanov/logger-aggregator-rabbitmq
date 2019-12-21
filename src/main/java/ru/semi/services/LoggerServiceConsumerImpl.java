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
        // TODO: 30.11.2019 save into cassandra
    }

    @RabbitListener(queues = ERROR_LOG_QUEUE)
    public void receiveErrorLogData(String message) {
        // TODO: 30.11.2019 save into elastic by index log-error
    }

    @RabbitListener(queues = BUSINESS_LOGIC_LOG_QUEUE)
    public void receiveBusinessLogData(String message) {
        // TODO: 30.11.2019 save into elastic by index business-logic
    }



}
