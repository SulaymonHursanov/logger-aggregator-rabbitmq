package ru.semi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class AbstractService {

    @Autowired
    ObjectMapper objectMapper;

    <T> String toJsonAsString(T t){
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            log.error("error occurred while converting object to json", e);
        }
        return null;
    }
}
