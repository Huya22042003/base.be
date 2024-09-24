package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsApiMenuPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsApiMenuPermissionsRepository extends JpaRepository<CpsApiMenuPermissionsEntity, String> {
}
