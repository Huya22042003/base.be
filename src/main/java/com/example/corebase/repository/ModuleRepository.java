package com.example.corebase.repository;

import com.example.corebase.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {
}
