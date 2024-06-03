package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectElementRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectGroupResponse;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.repository.ObjectGroupRepository;
import com.example.corebase.util.SimpleObjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SuObjectsGroupRepository extends ObjectGroupRepository {

    @Query(value = """
        SELECT 
            og.id AS id,
            og.code AS code,
            og.name AS name,
            og.sub_name AS subName,
            og.url_note AS urlNote,
            og.status AS status,
            og.order_by AS orderBy,
            r.role_name AS roleName,
            me.name AS moduleName
        FROM object_groups og 
            JOIN roles r ON og.role_id = r.id 
            JOIN module_entity me ON og.module_id = me.id
        WHERE og.is_active = 1
        AND (:#{#req.code} IS NULL OR og.code LIKE %:#{#req.code}%)
        AND (:#{#req.name} IS NULL OR og.name LIKE %:#{#req.name}%)
        AND (:#{#req.subName} IS NULL OR og.sub_name LIKE %:#{#req.subName}%)
        AND (:#{#req.roleId == NULL ? '' : #req.roleId} = '' OR og.role_id = :#{#req.roleId})
        AND (:#{#req.moduleId == NULL ? '' : #req.moduleId} = '' OR og.module_id = :#{#req.moduleId})
        AND (:#{#req.status == NULL ? '' : #req.status} = '' OR og.status LIKE %:#{#req.status}%)
    """, nativeQuery = true)
    Page<SuObjectGroupResponse> getAllObjectGroup(@Param("req") SuObjectGroupFilterRequest req, Pageable pageable);

    Long countByCodeAndIsActive(String code, ActiveStatus activeStatus);

    Long countByCodeAndIdNotAndIsActive(String code, UUID id, ActiveStatus activeStatus);

    @Query(value = """
                select 
                    r.id as id,
                    CONCAT(r.role_code, ' - ' , r.role_name) as name 
                from roles r
                where r.is_active = 1
            """, nativeQuery = true)
    List<SimpleObjectResponse> getAllRolesActive();

    @Query(value = """
                select 
                    me.id as id,
                    CONCAT(me.code, ' - ' , me.name) as name 
                from module_entity me
                where me.is_active = 1
            """, nativeQuery = true)
    List<SimpleObjectResponse> getAllModuleActive();

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

    @Query(value = """
                SELECT oeg.object_id as idObject, oe.parent_id as idParent 
                FROM object_element_group oeg 
                    join objects_entity oe on oeg.object_id = oe.id 
                where oeg.is_active = 1 and oe.is_active = 1
                and oeg.object_group_id = :idObjectGroup
            """, nativeQuery = true)
    List<SuObjectElementRequest> getObjectElementGroup(@Param("idObjectGroup") UUID idObjectGroup);

}
