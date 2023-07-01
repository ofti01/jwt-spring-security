package com.lotfi.jwtspringsecurity.repository;

import java.util.Optional;

import com.lotfi.jwtspringsecurity.models.ERole;
import com.lotfi.jwtspringsecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
