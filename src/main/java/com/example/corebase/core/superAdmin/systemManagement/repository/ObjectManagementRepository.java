package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.ObjectManagementFilterRequest;
import com.example.corebase.entity.Objects;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("objectManagementRepository")
public interface ObjectManagementRepository extends ObjectsRepository {

    @Query(value = """
        SELECT * FROM objects
        order by :#{#req.orderBy}
    """, nativeQuery = true)
    Page<Objects> findByCodeContainsAndNameContainsAndTypeAndOrderBy(@Param("req")ObjectManagementFilterRequest req, Pageable pageable);
}
