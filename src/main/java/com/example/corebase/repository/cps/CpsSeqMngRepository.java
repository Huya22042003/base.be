package com.example.corebase.repository.cps;

import com.example.corebase.entity.cps.CpsSeqMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsSeqMngRepository extends JpaRepository<CpsSeqMngEntity, String> {
}
