package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsToolMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsToolMngRepository extends JpaRepository<CpsToolMngEntity, String> {
}
