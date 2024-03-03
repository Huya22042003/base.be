package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.ObjectManagementFilterRequest;
import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("objectManagementRepository")
public interface ObjectManagementRepository extends ObjectsRepository {

    @Query(value = """
        SELECT * FROM objectsEntity
        order by :#{#req.orderBy}
    """, nativeQuery = true)
    Page<ObjectsEntity> findByCodeContainsAndNameContainsAndTypeAndOrderBy(@Param("req")ObjectManagementFilterRequest req, Pageable pageable);
}
