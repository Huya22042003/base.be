package com.example.corebase.core.superAdmin.informationManagement.repository;

import com.example.corebase.core.superAdmin.informationManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.response.SuObjectGroupAddResponse;
import com.example.corebase.core.superAdmin.informationManagement.model.response.SuPremiumManagementResponse;
import com.example.corebase.repository.PremiumTypesRepository;
import com.example.corebase.util.SimpleObjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("premiumManagementRepository")
public interface SuPremiumManagementRepository extends PremiumTypesRepository {

    @Query(value = """
        select
            pt.id as id,
            pt.code as code,
            pt.name as name,
            pt."level" as "level" ,
            r.role_name as roleName,
            pt."money" as "money" ,
            pt.note as note,
            pt.status as status,
            pt.is_default as isDefault,
            pt.type as type
        from premium_type pt join roles r on pt.role_id = r.id
        where pt.is_active = 1
        AND (:#{#req.code == NULL ? '' : #req.code} = '' OR pt.code LIKE %:#{#req.code}%)
        AND (:#{#req.name == NULL ? '' : #req.name} = '' OR pt.name LIKE %:#{#req.name}%)
        AND (:#{#req.roleId == NULL ? '' : #req.roleId} = '' OR pt.role_id = :#{#req.roleId})
        AND (:#{#req.moneyEnd == NULL ? -1 : #req.moneyEnd} = -1 OR pt.money <= :#{#req.moneyEnd})
        AND (:#{#req.moneyStart == NULL ? -1 : #req.moneyEnd} = -1 OR pt.money <= :#{#req.moneyEnd})
        AND (:#{#req.status == NULL ? '' : #req.status} = '' OR pt.status LIKE %:#{#req.status}%)
        AND (:#{#req.isDefault == NULL ? '' : #req.isDefault} = '' OR pt.is_default LIKE %:#{#req.isDefault}%)
        AND (:#{#req.type == NULL ? '' : #req.type} = '' OR pt.type LIKE %:#{#req.type}%)
        AND (:#{#req.note == NULL ? '' : #req.note} = '' OR pt.note LIKE %:#{#req.note}%)
    """, nativeQuery = true)
    Page<SuPremiumManagementResponse> getPagePremiumManagement(@Param("req") SuPremiumTypeFilterRequest req, Pageable pageable);

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
        		og.id as id,
        		og.code as code,
        		og.name as name,
        		og.sub_name as subName,
        		og.status as status 
        	from object_groups og
        	where og.is_active = 1
            AND (:#{#req.code == NULL ? '' : #req.code} = '' OR og.code LIKE %:#{#req.code}%)
            AND (:#{#req.name == NULL ? '' : #req.name} = '' OR og.name LIKE %:#{#req.name}%)
            AND (:#{#req.subName == NULL ? '' : #req.subName} = '' OR og.sub_name LIKE %:#{#req.subName}%)
            AND (og.role_id = :#{#req.roleId})
    """, nativeQuery = true)
    Page<SuObjectGroupAddResponse> getAllObjectGroup(@Param("req")SuObjectGroupFilterRequest req, Pageable pageable);

}
