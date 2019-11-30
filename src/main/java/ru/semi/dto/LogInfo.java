package ru.semi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LogInfo {
    @NotNull(message = "logData can't be null")
    private LogData logData;
    private String type;
    @NotEmpty(message = "required field 'client'")
    private String client;
    private String logLevel;
}
