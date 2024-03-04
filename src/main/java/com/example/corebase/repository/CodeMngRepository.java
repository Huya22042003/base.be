package com.example.corebase.repository;

import com.example.corebase.entity.CodeMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeMngRepository extends JpaRepository<CodeMngEntity, Long> {
}
