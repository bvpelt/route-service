package nl.bsoft.routeservice.services;

import lombok.extern.slf4j.Slf4j;
import nl.bsoft.routeservice.repositories.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService {

    private LogEntryRepository logEntryRepository = null;

    @Autowired
    public LogService(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }
}
