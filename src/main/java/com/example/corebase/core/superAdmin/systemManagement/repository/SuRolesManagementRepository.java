package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuRolesManagementResponse;
import com.example.corebase.entity.RolesEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.repository.RolesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("rolesManagementRepository")
public interface SuRolesManagementRepository extends RolesRepository {

    @Query(value = """
        SELECT 
            r.id,
            r.role_name as roleName,
            r.role_code as roleCode
        FROM roles r 
        where r.is_active = 1
            and (:#{#req.roleCode} is null or :#{#req.roleCode} = '' or r.role_code like %:#{#req.roleCode}%)
            and (:#{#req.roleName} is null or :#{#req.roleName} = '' or r.role_name like %:#{#req.roleName}%)
    """, nativeQuery = true)
    Page<SuRolesManagementResponse> findRoleOnPage(@Param("req") SuRolesManagementFilterRequest req, Pageable pageable);

    @Query(value = """
        select
            o.id,
            o.code,
            o.name,
            o.key,
            o.url,
            o.icons,
            o.parent_id ,
             fn_code_name(o."type") as "type",
            o.order_by 
        from objects_entity o
        where o.is_active = 1
        """, nativeQuery = true)
    List<SuMenuLoginResponse> getAllMenuLoginResponse();

    Long countByRoleCodeAndIsActive(String code, ActiveStatus activeStatus);

    Long countByRoleCodeAndIdNotAndIsActive(String code, Long id, ActiveStatus activeStatus);
}
