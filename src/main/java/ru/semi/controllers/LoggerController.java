package ru.semi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.semi.dto.LogInfo;
import ru.semi.services.interfaces.LoggerServiceProducer;

import javax.validation.Valid;

@RestController
@RequestMapping("/logger")
@Slf4j
public class LoggerController {

    @Autowired
    private LoggerServiceProducer loggerServiceProducer;

    @RequestMapping(value = "/append", method = RequestMethod.POST)
    public ResponseEntity appendNewLog(@RequestBody @Valid LogInfo logInfo){
        log.debug("requested from client: {}", logInfo.getClient());
        loggerServiceProducer.sendLogData(logInfo);
        return ResponseEntity.ok().build();
    }
}
