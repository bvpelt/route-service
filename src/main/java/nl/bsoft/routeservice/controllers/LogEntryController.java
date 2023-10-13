package nl.bsoft.routeservice.controllers;

import lombok.extern.slf4j.Slf4j;
import nl.bsoft.routeservice.domain.LogEntry;
import nl.bsoft.routeservice.domain.LogEntryList;
import nl.bsoft.routeservice.domain.LogEntryResult;
import nl.bsoft.routeservice.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
@CrossOrigin(
        origins = "http://localhost:8080",
       // originPatterns =  "*",
        allowCredentials = "true",
        allowedHeaders = {"*"},
        methods = {
                RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST,
                RequestMethod.OPTIONS
        })
 */

@RestController
@Slf4j
public class LogEntryController {
    private LogService logService = null;

    @Autowired
    public LogEntryController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/api/logs")
    public ResponseEntity<LogEntryList> getLogEntries() {
        log.info("/api/logs - get");
        Iterable<LogEntry> logEntries = logService.getAll();
        LogEntryList logEntriesResult = new LogEntryList();

        for (LogEntry logEntry : logEntries) {
            logEntriesResult.getLogEntries().add(logEntry);
        }

        return new ResponseEntity<LogEntryList>(logEntriesResult, HttpStatus.OK);
    }

    /*
    POST
     */
    @PostMapping("/api/logs")
    public ResponseEntity<LogEntryResult> saveLogEntry(@RequestBody final LogEntry logEntry) {
        log.info("/api/logs - post, body: {}", logEntry);

        LogEntry savedLogEntry = logService.save(logEntry);
        LogEntryResult logEntryResult = new LogEntryResult();
        logEntryResult.setLogentry(savedLogEntry);
        logEntryResult.setResult(savedLogEntry != null);

        return new ResponseEntity<>(logEntryResult, HttpStatus.OK);
    }
}
