package ru.semi.config;

public class RabbitMQ {
    public static final String TOPIC_EXCHANGE_NAME = "logger-exchange";
    public static final String DIRECT_EXCHANGE_NAME = "business-logger-exchange";
    public static final String METRIC_DIRECT_EXCHANGE_NAME = "business-logger-exchange";
    public static final String LOG_QUEUE = "log-queue";
    public static final String ERROR_LOG_QUEUE = "error-log-queue";
    public static final String BUSINESS_LOGIC_LOG_QUEUE = "business-logic-log-queue";
    public static final String METRIC_QUEUE = "metric-queue";
    public static final String LOG_QUEUE_BINDING = "*.log-binding";
    public static final String ERROR_LOG_BINDING = "error-log-binding";
    public static final String BUSINESS_LOGIC_LOG_BINDING = "business-logic-log-binding";
    public static final String METRIC_BINDING = "metric-binding";
}
