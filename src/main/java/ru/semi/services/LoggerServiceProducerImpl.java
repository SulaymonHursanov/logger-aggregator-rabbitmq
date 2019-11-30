package ru.semi.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.semi.dto.LogInfo;
import ru.semi.services.interfaces.LoggerServiceProducer;

import static ru.semi.config.RabbitMQ.*;

@Service
public class LoggerServiceProducerImpl extends AbstractService implements LoggerServiceProducer {

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
