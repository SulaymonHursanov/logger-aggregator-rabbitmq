package ru.semi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final String topicExchangeName = "logger-exchange";
    private final String logQueueName = "log-queue";
    private final String errorLogQueueName = "error-log-queue";
    private final String businessLogicLogQueueName = "business-logic-log-queue";
    private final String logQueueBinding = "log-binding";
    private final String errorLogQueueBinding = "error-log-binding";
    private final String businessLogicLogBinding = "business-logic-log-binding";

    @Bean
    public Queue logQueue() {
        return new Queue(logQueueName, true, false, false);
    }

    @Bean
    public Queue errorLogQueue(){
        return new Queue(errorLogQueueName, true, false, false);
    }

    @Bean
    public Queue businessLogicLogQueue(){
        return new Queue(businessLogicLogQueueName, true, false, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding logBinding(){
        return BindingBuilder.bind(logQueue()).to(exchange()).with(logQueueBinding);
    }

    @Bean
    public Binding errorLogBinding(){
        return BindingBuilder.bind(errorLogQueue()).to(exchange()).with(errorLogQueueBinding);
    }

    @Bean
    public Binding businessLogicLogBinding(){
        return BindingBuilder.bind(businessLogicLogQueue()).to(exchange()).with(businessLogicLogBinding);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.addQueueNames(logQueueName, errorLogQueueName, businessLogicLogQueueName);
        return messageListenerContainer;
    }
}
