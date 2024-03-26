package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository("objectManagementRepository")
public interface ObjectManagementRepository extends ObjectsRepository {

    Page<ObjectsEntity> findByCodeContainsAndNameContains(String name, String code, Pageable pageable);
}
