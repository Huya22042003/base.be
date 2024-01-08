package com.example.corebase.repository;

import com.example.corebase.entity.RoleObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleObjectRepository extends JpaRepository<RoleObject, Long> {
    static final String BASE_NAME = "role_object_repository";
}
