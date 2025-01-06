package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsModuleMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsModuleMngRepository extends JpaRepository<CpsModuleMngEntity, String> {
}
