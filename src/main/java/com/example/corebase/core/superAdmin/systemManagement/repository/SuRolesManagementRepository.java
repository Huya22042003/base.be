package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.entity.RolesEntity;
import com.example.corebase.repository.RolesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository("rolesManagementRepository")
public interface SuRolesManagementRepository extends RolesRepository {
    Page<RolesEntity> findByRoleNameContainingAndRoleCodeContaining(String name, String code, Pageable pageable);
}
