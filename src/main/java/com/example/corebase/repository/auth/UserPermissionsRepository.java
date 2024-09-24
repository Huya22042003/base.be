package com.example.corebase.repository.auth;

import com.example.corebase.entity.auth.UserPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionsRepository extends JpaRepository<UserPermissionsEntity, String> {
}
