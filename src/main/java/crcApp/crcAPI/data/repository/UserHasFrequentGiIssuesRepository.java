package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.UserHasFrequentGiIssues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for UserHasFrequentGiIssues
 */
public interface UserHasFrequentGiIssuesRepository extends JpaRepository<UserHasFrequentGiIssues, Long> {

//    Optional<UserHasFrequentGiIssues> findUserHasFrequentGiIssuesByUserId(Long id);

   List<UserHasFrequentGiIssues> findUserHasFrequentGiIssuesByUserId(Long id);

//   @Modifying(flushAutomatically = true)
   void deleteAllByUserId(Long id);

}
