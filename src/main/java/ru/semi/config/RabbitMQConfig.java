package ru.semi.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.semi.config.RabbitMQ.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue logQueue() {
        return new Queue(LOG_QUEUE, true, false, false);
    }

    @Bean
    public Queue errorLogQueue(){
        return new Queue(ERROR_LOG_QUEUE, true, false, false);
    }

    @Bean
    public Queue businessLogicLogQueue(){
        return new Queue(BUSINESS_LOGIC_LOG_QUEUE, true, false, false);
    }

    @Bean
    public Queue metricQueue(){
        return new Queue(METRIC_QUEUE, true, false, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public DirectExchange metricDirectExchange(){
        return new DirectExchange(METRIC_DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Binding logBinding(){
        return BindingBuilder.bind(logQueue()).to(topicExchange()).with(LOG_QUEUE_BINDING);
    }

    @Bean
    public Binding errorLogBinding(){
        return BindingBuilder.bind(errorLogQueue()).to(topicExchange()).with(ERROR_LOG_BINDING);
    }

    @Bean
    public Binding businessLogicLogBinding(){
        return BindingBuilder.bind(businessLogicLogQueue()).to(directExchange()).with(BUSINESS_LOGIC_LOG_BINDING);
    }

    @Bean
    public Binding metricBinding(){
        return BindingBuilder.bind(metricQueue()).to(metricDirectExchange()).with(METRIC_BINDING);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.addQueueNames(LOG_QUEUE, ERROR_LOG_QUEUE, BUSINESS_LOGIC_LOG_QUEUE, METRIC_QUEUE);
        return messageListenerContainer;
    }
}
