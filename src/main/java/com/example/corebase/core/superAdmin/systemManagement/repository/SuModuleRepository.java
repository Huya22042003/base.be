package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuModuleResponse;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.repository.ModuleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SuModuleRepository extends ModuleRepository {

    @Query(value = """
        SELECT 
            me.id AS id,
            me.code AS code,
            me.name AS name,
            me.url AS url,
            me.note AS note,
            me.status AS status
        FROM module_entity me
        WHERE me.is_active = 1
        AND (:#{#req.code} is null or :#{#req.code} = '' or me.code like :#{#req.code})
        AND (:#{#req.name} is null or :#{#req.name} = '' or me.name like %:#{#req.name}%)
        AND (:#{#req.url} is null or :#{#req.url} = '' or me.url like %:#{#req.url}%)
        AND (:#{#req.note} is null or :#{#req.note} = '' or me.note like %:#{#req.note}%)
        AND (:#{#req.status} is null or :#{#req.status} = '' or me.status like %:#{#req.status}%)
    """, nativeQuery = true)
    Page<SuModuleResponse> getAllModuleManagement(@Param("req") SuModuleFilterRequest req, Pageable pageable);

    Long countByCodeAndIsActive(String code, ActiveStatus activeStatus);

    Long countByCodeAndIdNotAndIsActive(String code, UUID id, ActiveStatus activeStatus);
}
