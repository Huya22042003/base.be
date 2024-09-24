package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsResourceMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsResourceMngRepository extends JpaRepository<CpsResourceMngEntity, String> {
}
