package com.example.serviceauth.domain.aggregate.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByUserName(String userName);
}