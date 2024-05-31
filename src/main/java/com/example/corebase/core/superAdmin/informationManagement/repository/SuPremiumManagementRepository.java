package com.example.corebase.core.superAdmin.informationManagement.repository;

import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.response.SuPremiumManagementResponse;
import com.example.corebase.repository.PremiumTypesRepository;
import com.example.corebase.util.SimpleObjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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
            pt.status as status
        from premium_type pt join roles r on pt.role_id = r.id
        where pt.is_active = 1
    """, nativeQuery = true)
    Page<SuPremiumManagementResponse> getPagePremiumManagement(SuPremiumTypeFilterRequest request, Pageable pageable);

    @Query(value = """
        select 
            r.id as id,
            CONCAT(r.role_code, ' - ' , r.role_name) as name 
        from roles r
        where r.is_active = 1
    """, nativeQuery = true)
    List<SimpleObjectResponse> getAllRolesActive();

}
