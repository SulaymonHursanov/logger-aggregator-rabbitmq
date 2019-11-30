package ru.semi.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.semi.config.RabbitMQ;
import ru.semi.dto.LogInfo;
import ru.semi.services.interfaces.MetricServiceProducer;

import static ru.semi.config.RabbitMQ.*;

@Service
public class MetricServiceProducerImpl extends AbstractService implements MetricServiceProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMetric(LogInfo logInfo) {
        String messageData = toJsonAsString(logInfo);
        rabbitTemplate.convertAndSend(METRIC_DIRECT_EXCHANGE_NAME, METRIC_BINDING, messageData);
    }
}
