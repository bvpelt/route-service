package nl.bsoft.routeservice.controllers;

import lombok.extern.slf4j.Slf4j;
import nl.bsoft.routeservice.domain.LogEntry;
import nl.bsoft.routeservice.domain.LogEntryResult;
import nl.bsoft.routeservice.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class LogEntryController {
    private LogService logService = null;

    @Autowired
    public LogEntryController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    //public ResponseEntity<LogEntryList> getLogEntries() {
    public ResponseEntity<Iterable<LogEntry>> getLogEntries() {
        log.info("/logs - get");
        Iterable<LogEntry> logEntries = logService.getAll();
        /*
        LogEntryList logEntriesResult = new LogEntryList();

        for (LogEntry logEntry : logEntries) {
            logEntriesResult.getLogEntries().add(logEntry);
        }

        return new ResponseEntity<LogEntryList>(logEntriesResult, HttpStatus.OK);

         */
        return new ResponseEntity<Iterable<LogEntry>>(logEntries, HttpStatus.OK);
    }

    @GetMapping("/logs/max")
    //public ResponseEntity<LogEntryList> getLogEntries() {
    public ResponseEntity<Iterable<LogEntry>> getMaxLogEntries() {
        log.info("/logs/max - get");
        Iterable<LogEntry> logEntries = logService.getAllLimited(20);
        /*
        LogEntryList logEntriesResult = new LogEntryList();

        for (LogEntry logEntry : logEntries) {
            logEntriesResult.getLogEntries().add(logEntry);
        }

        return new ResponseEntity<LogEntryList>(logEntriesResult, HttpStatus.OK);

         */
        return new ResponseEntity<Iterable<LogEntry>>(logEntries, HttpStatus.OK);
    }

    @GetMapping("/logs/page")
    public ResponseEntity<?> logEntriesWithPagination(@RequestParam(value = "pageNumber", defaultValue = "0", required = true) int pageNumber,
                                                      @RequestParam(value = "pageSize", defaultValue = "10", required = true) int pageSize,
                                                      @RequestParam(value = "sortedBy", defaultValue = "entryDate", required = true) String sortBy) {
        log.info("LogEntryController.logEntriesWithPagination - pageNumber: {}, pageSize: {}, sortBy: {}", pageNumber, pageSize, sortBy);
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        Page<LogEntry> logentriesPage = logService.getAllPaged(pageRequest);
        List<LogEntry> logentries = logentriesPage.getContent();

        return ResponseEntity.status(HttpStatus.OK).body(logentries);
    }

    /*
    POST
     */
    @PostMapping("/logs")
    public ResponseEntity<LogEntryResult> saveLogEntry(@RequestBody final LogEntry logEntry) {
        log.info("/logs - post, body: {}", logEntry);

        LogEntry savedLogEntry = logService.save(logEntry);
        LogEntryResult logEntryResult = new LogEntryResult();
        logEntryResult.setLogentry(savedLogEntry);
        logEntryResult.setResult(savedLogEntry != null);

        return new ResponseEntity<>(logEntryResult, HttpStatus.OK);
    }
}
