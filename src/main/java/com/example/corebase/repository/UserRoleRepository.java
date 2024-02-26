package com.example.corebase.repository;

import com.example.corebase.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    static final String BASE_NAME = "user_role_repository";
}
