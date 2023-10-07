package nl.bsoft.routeservice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogEntryResult {
    private LogEntry logentry;
    private boolean result;
}
