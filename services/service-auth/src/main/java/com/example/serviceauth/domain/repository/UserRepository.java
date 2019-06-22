package com.example.serviceauth.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.example.serviceauth.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByUserName(String userName);
}