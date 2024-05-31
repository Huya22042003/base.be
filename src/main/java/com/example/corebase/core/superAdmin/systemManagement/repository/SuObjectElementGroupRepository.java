package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.entity.ObjectElementGroup;
import com.example.corebase.repository.ObjectElementGroupRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SuObjectElementGroupRepository extends ObjectElementGroupRepository {

    List<ObjectElementGroup> findByObjectGroupId(@Param("idObjectGroup") UUID idObjectGroup);

}
