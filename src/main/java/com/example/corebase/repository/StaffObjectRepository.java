package com.example.corebase.repository;

import com.example.corebase.entity.StaffObjectGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffObjectRepository extends JpaRepository<StaffObjectGroup, UUID> {
}
