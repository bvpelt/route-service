package nl.bsoft.routeservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class LogEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private LocalDateTime entryData;

    private String message;

    private String extraInfo;

    private LogLevel logLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return entryData.equals(logEntry.entryData) && message.equals(logEntry.message) && Objects.equals(extraInfo, logEntry.extraInfo) && logLevel == logEntry.logLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryData, message, extraInfo, logLevel);
    }
}
