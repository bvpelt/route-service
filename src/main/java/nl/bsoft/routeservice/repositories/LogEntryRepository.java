package nl.bsoft.routeservice.repositories;

import nl.bsoft.routeservice.domain.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Integer> {
    String FIND_ALL_LOGENTRIES_ORDEREDBY_DATE_QUERY = "SELECT l " +
            "FROM LogEntry l " +
            "ORDER BY l.entryDate DESC";
    String FIND_ALL_LOGENTRIES_ORDEREDBY_DATE_LIMITED_QUERY = "SELECT l " +
            "FROM LogEntry l " +
            "ORDER BY l.entryDate DESC Limit :maxnumber";

    @Query(FIND_ALL_LOGENTRIES_ORDEREDBY_DATE_QUERY)
    List<LogEntry> findAll();

    @Query(FIND_ALL_LOGENTRIES_ORDEREDBY_DATE_LIMITED_QUERY)
    List<LogEntry> findAllLimited(@Param("maxnumber") int maxnumber);
}
