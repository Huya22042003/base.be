package com.example.corebase.repository;

import com.example.corebase.entity.FoodStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodStoreRepository extends JpaRepository<FoodStoreEntity, String> {
}
