package com.example.corebase.repository;

import com.example.corebase.entity.ObjectGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectGroupRepository extends JpaRepository<ObjectGroups, UUID> {
}
