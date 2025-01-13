package com.example.corebase.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRoleRepository extends JpaRepository<SysMenuRoleRepository, String> {
}
