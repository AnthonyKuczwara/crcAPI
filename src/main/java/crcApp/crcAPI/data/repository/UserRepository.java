package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Users
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Long id);
    List<User> findAll();

}
