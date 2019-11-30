package ru.semi.services.interfaces;

import ru.semi.dto.LogInfo;

public interface MetricServiceProducer {
    void sendMetric(LogInfo logInfo);
}
