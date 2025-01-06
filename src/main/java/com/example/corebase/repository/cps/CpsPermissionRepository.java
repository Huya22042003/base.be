package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsPermissionRepository extends JpaRepository<CpsPermissionEntity, String> {
}
