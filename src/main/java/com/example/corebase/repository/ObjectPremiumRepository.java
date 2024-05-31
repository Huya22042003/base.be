package com.example.corebase.repository;

import com.example.corebase.entity.ObjectGroupPremiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectPremiumRepository extends JpaRepository<ObjectGroupPremiumEntity, UUID> {
    static final String BASE_NAME = "object_premium_repository";
}
