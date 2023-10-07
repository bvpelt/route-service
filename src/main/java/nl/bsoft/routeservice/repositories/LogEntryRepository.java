package nl.bsoft.routeservice.repositories;

import nl.bsoft.routeservice.domain.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<LogEntry, Integer> {
}
