package com.example.corebase.repository;

import com.example.corebase.entity.UserPremiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPremiumRepository extends JpaRepository<UserPremiumEntity, Long> {
    static final String BASE_NAME = "user_premium_repository";
}
