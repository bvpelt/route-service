package nl.bsoft.routeservice.repositories;

import nl.bsoft.routeservice.domain.LogEntry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryPagingRepository extends PagingAndSortingRepository<LogEntry, Integer> {
/*
    String FIND_ALL_LOGENTRIES_ORDEREDBY_QUERY = "SELECT l " +
            "FROM LogEntry l " +
            "ORDER BY l.entryDate";

    @Query(FIND_ALL_LOGENTRIES_ORDEREDBY_QUERY)
    Page<LogEntry> findAll(Pageable pageable);

 */
}
