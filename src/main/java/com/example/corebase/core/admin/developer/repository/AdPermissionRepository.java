package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.core.admin.developer.model.request.AdPermissionFilterRequest;
import com.example.corebase.core.admin.developer.model.response.AdPermissionResponse;
import com.example.corebase.repository.cps.CpsPermissionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdPermissionRepository extends CpsPermissionRepository {

    @Query(value = """
        SELECT 
            cp.id as id,
            cp.name as name,
            FN_GET_CODE_NAME(cp.default_yn) as defaultNm,
            FN_GET_CODE_NAME(cp.use_yn) as useNm,
            crm.name as roleNm
        FROM cps_permission cp 
        JOIN cps_role_mng crm ON cp.role_id = crm.id 
    """, nativeQuery = true)
    Page<AdPermissionResponse> getPagePermission(@Param("req") AdPermissionFilterRequest req, Pageable pageable);
}
