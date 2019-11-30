package ru.semi.services.interfaces;

import ru.semi.dto.LogInfo;

public interface LoggerServiceProducer {
    void sendLogData(LogInfo logInfo);
}
