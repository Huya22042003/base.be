package com.example.corebase.repository;

import com.example.corebase.entity.FileMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMngRepository extends JpaRepository<FileMngEntity, Long> {
}
