package com.example.corebase.repository;

import com.example.corebase.entity.UserPremiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserPremiumRepository extends JpaRepository<UserPremiumEntity, UUID> {
    static final String BASE_NAME = "user_premium_repository";
}
