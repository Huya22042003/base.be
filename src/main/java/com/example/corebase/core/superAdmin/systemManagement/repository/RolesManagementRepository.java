package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.entity.Roles;
import com.example.corebase.repository.RolesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository("rolesManagementRepository")
public interface RolesManagementRepository extends RolesRepository {
    Page<Roles> findByRoleNameContainingAndRoleCodeContaining(String name, String code, Pageable pageable);
}
