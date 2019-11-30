package ru.semi.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.semi.dto.LogInfo;

import static ru.semi.config.RabbitMQ.*;

@Service
public class LoggerServiceImpl extends AbstractService implements LoggerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendLogData(LogInfo logInfo) {
        String logAsString = toJsonAsString(logInfo);

        if ("businessLogic".equals(logInfo.getType())){
            rabbitTemplate.convertAndSend(DIRECT_EXCHANGE_NAME, BUSINESS_LOGIC_LOG_BINDING, logAsString);
        }else if ("errorLog".equals(logInfo.getLogLevel())){
            rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ERROR_LOG_BINDING, logAsString);
        }

        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, LOG_QUEUE_BINDING, logAsString);

    }
}
