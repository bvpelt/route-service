package nl.bsoft.routeservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "log_entry")
public class LogEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @JsonProperty("entryDate")
    @Column(name = "entrydate")
    private LocalDateTime entryDate;

    private String message;


    @JsonProperty("extraInfo")
    @Column(name = "extrainfo")
    private String extraInfo;

    @JsonProperty("logLevel")
    @Column(name = "loglevel")
    private LogLevel logLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return entryDate.equals(logEntry.entryDate) && message.equals(logEntry.message) && Objects.equals(extraInfo, logEntry.extraInfo) && logLevel == logEntry.logLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryDate, message, extraInfo, logLevel);
    }
}
