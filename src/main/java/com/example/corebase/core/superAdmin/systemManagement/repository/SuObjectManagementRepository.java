package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectsManagementResponse;
import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("objectManagementRepository")
public interface SuObjectManagementRepository extends ObjectsRepository {

    @Query(value = """
        select
            ROW_NUMBER() OVER (ORDER BY created_date) AS stt,
        	oe.id ,
        	oe.code ,
        	oe."name" ,
        	oe."key" ,
        	fn_code_name(oe."type") as type,
        	oe.is_start
        from objects_entity oe
        where oe.is_active = 1
        and (:#{#req.code} is null or :#{#req.code} = '' or oe.code like :#{#req.code})
        and (:#{#req.name} is null or :#{#req.name} = '' or oe.name like :#{#req.name})
        and (:#{#req.typeObjects} is null or :#{#req.typeObjects} = '' or oe.type like :#{#req.typeObjects})
                                     
    """, nativeQuery = true)
    Page<SuObjectsManagementResponse> getAllObjectsManagement(@Param("req") SuObjectManagementFilterRequest req, Pageable pageable);
}
