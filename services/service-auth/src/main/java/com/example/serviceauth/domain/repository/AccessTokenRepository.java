package com.example.serviceauth.domain.repository;

import java.util.UUID;

import com.example.serviceauth.domain.entity.AccessToken;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccessTokenRepository
 */
public interface AccessTokenRepository extends JpaRepository<AccessToken, UUID> {

}