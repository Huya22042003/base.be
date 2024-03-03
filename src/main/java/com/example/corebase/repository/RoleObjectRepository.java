package com.example.corebase.repository;

import com.example.corebase.entity.RoleObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleObjectRepository extends JpaRepository<RoleObjectEntity, Long> {
    static final String BASE_NAME = "role_object_repository";
}
