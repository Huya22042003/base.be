package com.example.corebase.repository;

import com.example.corebase.entity.ObjectPremiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectPremiumRepository extends JpaRepository<ObjectPremiumEntity, Long> {
    static final String BASE_NAME = "object_premium_repository";
}
