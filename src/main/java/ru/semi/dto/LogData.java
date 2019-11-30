package ru.semi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LogData {
    @NotEmpty(message = "payload can not be null or empty")
    private String payload;
}
