package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.admin.developer.model.response.AdResourceMngResponse;
import com.example.corebase.repository.cps.CpsResourceMngRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdResourceMngRepository extends CpsResourceMngRepository {

    @Query(value = """
                SELECT 
                    crm.id as id,
                    crm.api as api,
                    crm.name as name,
                    FN_GET_CODE_NAME(crm.role) as role,
                    FN_GET_CODE_NAME(crm.use_yn) as useYn,
                    cmm.name as module,
                    FN_GET_CODE_NAME(crm.method) as method
                FROM CPS_RESOURCE_MNG crm 
                JOIN CPS_MODULE_MNG cmm ON cmm.id = crm.module
                WHERE crm.del_yn = :#{#req.delYn}
                    AND (:#{#req.api} IS NULL OR crm.api LIKE CONCAT('%', :#{#req.api}, '%'))
                    AND (:#{#req.name} IS NULL OR crm.name LIKE CONCAT('%', :#{#req.name}, '%'))
                    AND (:#{#req.role} IS NULL OR crm.role LIKE CONCAT('%', :#{#req.role}, '%'))
                    AND (:#{#req.useYn} IS NULL OR crm.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
                    AND (:#{#req.module} IS NULL OR crm.module LIKE CONCAT('%', :#{#req.module}, '%'))
                    AND (:#{#req.method} IS NULL OR crm.method LIKE CONCAT('%', :#{#req.method}, '%'))
            """, countQuery = """
                SELECT 
                    crm.id as id
                FROM CPS_RESOURCE_MNG crm 
                JOIN CPS_MODULE_MNG cmm ON cmm.id = crm.module
                WHERE crm.del_yn = :#{#req.delYn}
                    AND (:#{#req.api} IS NULL OR crm.api LIKE CONCAT('%', :#{#req.api}, '%'))
                    AND (:#{#req.name} IS NULL OR crm.name LIKE CONCAT('%', :#{#req.name}, '%'))
                    AND (:#{#req.role} IS NULL OR crm.role LIKE CONCAT('%', :#{#req.role}, '%'))
                    AND (:#{#req.useYn} IS NULL OR crm.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
                    AND (:#{#req.module} IS NULL OR crm.module LIKE CONCAT('%', :#{#req.module}, '%'))
                    AND (:#{#req.method} IS NULL OR crm.method LIKE CONCAT('%', :#{#req.method}, '%'))
            """, nativeQuery = true)
    Page<AdResourceMngResponse> getPageResource(@Param("req") AdResourceFilterRequest req, Pageable pageable);
}
