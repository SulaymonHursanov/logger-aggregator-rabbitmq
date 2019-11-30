package ru.semi.services;

import ru.semi.dto.LogInfo;

public interface LoggerService {
    void sendLogData(LogInfo logInfo);
}
