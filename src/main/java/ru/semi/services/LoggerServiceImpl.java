package ru.semi.services;

import org.springframework.stereotype.Service;
import ru.semi.dto.LogInfo;

@Service
public class LoggerServiceImpl extends AbstractService implements LoggerService {

    @Override
    public void sendLogData(LogInfo logInfo) {
        String logAsString = toJsonAsString(logInfo);

        if ("businessLogic".equals(logInfo.getType())){
            // todo: send to business logic queue
        }else if ("errorLog".equals(logInfo.getLogLevel())){
            // todo: send to error log queue
        }

        // todo: send to log queue

    }
}
