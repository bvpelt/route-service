package nl.bsoft.routeservice.services;

import lombok.extern.slf4j.Slf4j;
import nl.bsoft.routeservice.domain.LogEntry;
import nl.bsoft.routeservice.repositories.LogEntryPagingRepository;
import nl.bsoft.routeservice.repositories.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService {

    private LogEntryRepository logEntryRepository = null;

    private LogEntryPagingRepository logEntryPagingRepository = null;

    @Autowired
    public LogService(LogEntryRepository logEntryRepository, LogEntryPagingRepository logEntryPagingRepository) {
        this.logEntryRepository = logEntryRepository;
        this.logEntryPagingRepository = logEntryPagingRepository;
    }

    public LogEntry save(LogEntry logEntry) {
        LogEntry savedLogentry = null;

        savedLogentry = logEntryRepository.save(logEntry);

        return savedLogentry;
    }

    public Iterable<LogEntry> getAll() {
        return logEntryRepository.findAll();
    }

    public Iterable<LogEntry> getAllLimited(int maxnumber) {
        return logEntryRepository.findAllLimited(maxnumber);
    }

    public Page<LogEntry> getAllPaged(PageRequest pageRequest) {
        log.info("LogService.getAllPaged pageRequest - page: {}, pageSize: {}, sortedby: {}", pageRequest.getPageNumber(), pageRequest.getPageSize(), pageRequest.getSort());
        return logEntryPagingRepository.findAll(pageRequest);
    }
}
