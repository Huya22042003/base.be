package com.example.corebase.repository;

import com.example.corebase.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    static final String BASE_NAME = "user_role_repository";
}
