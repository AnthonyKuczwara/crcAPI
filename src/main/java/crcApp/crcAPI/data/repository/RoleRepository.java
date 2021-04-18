package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.ERole;
import crcApp.crcAPI.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
