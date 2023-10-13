package nl.bsoft.routeservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LogEntryList {

    private List<LogEntry> logEntries = new ArrayList<LogEntry>();
}
