package com.example.serviceauth.domain.aggregate.accesstoken;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccessTokenRepository
 */
public interface AccessTokenRepository extends JpaRepository<AccessToken, UUID> {

}