package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.FrequentGiIssues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for ActivityLevel
 */
public interface FrequentGiIssueRepository extends JpaRepository<FrequentGiIssues, Long> {

    Optional<FrequentGiIssues> findFrequentGiIssuesById(Long id);
    Optional<FrequentGiIssues> findFrequentGiIssuesByIssue(String issue);


}
