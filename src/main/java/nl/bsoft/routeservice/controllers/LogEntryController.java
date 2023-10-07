package nl.bsoft.routeservice.controllers;

import lombok.extern.slf4j.Slf4j;
import nl.bsoft.routeservice.domain.LogEntry;
import nl.bsoft.routeservice.domain.LogEntryResult;
import nl.bsoft.routeservice.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
public class LogEntryController {
    private LogService logService = null;

    @Autowired
    public LogEntryController(LogService logService) {
        this.logService = logService;
    }

    /*
    POST
     */
    public ResponseEntity<LogEntryResult> saveLogEntry(@RequestBody final LogEntry logEntry) {
        log.info("Adding logentry");

        LogEntry savedLogEntry = logService.
    }
}
