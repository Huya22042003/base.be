package com.example.corebase.repository;

import com.example.corebase.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    static final String BASE_NAME = "roles_repository";
}
