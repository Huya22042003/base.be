package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsRoleMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsRoleMngRepository extends JpaRepository<CpsRoleMngEntity, String> {
}
