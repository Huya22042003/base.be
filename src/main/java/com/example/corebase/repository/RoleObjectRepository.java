package com.example.corebase.repository;

import com.example.corebase.entity.RoleObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleObjectRepository extends JpaRepository<RoleObjectEntity, UUID> {
    static final String BASE_NAME = "role_object_repository";
}
