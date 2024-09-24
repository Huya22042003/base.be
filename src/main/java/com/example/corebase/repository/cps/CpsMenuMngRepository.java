package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsMenuMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsMenuMngRepository extends JpaRepository<CpsMenuMngEntity, String> {
}
