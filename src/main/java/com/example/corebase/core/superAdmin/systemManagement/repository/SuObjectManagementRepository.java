package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuDetailResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuParentResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectsManagementResponse;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("objectManagementRepository")
public interface SuObjectManagementRepository extends ObjectsRepository {

    @Query(value = """
              select
                oe.id as id,
                oe.code as code,
                oe."name" as name,
                oe."key" as "key",
                fn_code_name(oe."type") as "type",
                oe.is_start as isStart
              from objects_entity oe
              where oe.is_active = 1
                and (:#{#req.code} is null or :#{#req.code} = '' or oe.code like %:#{#req.code}%)
                and (:#{#req.name} is null or :#{#req.name} = '' or oe.name like %:#{#req.name}%)
                and (:#{#req.typeObjects} is null or :#{#req.typeObjects} = '' or oe.type like %:#{#req.typeObjects}%)
    """, nativeQuery = true)
    Page<SuObjectsManagementResponse> getAllObjectsManagement(@Param("req") SuObjectManagementFilterRequest req, Pageable pageable);

    @Query(value = """
              select
                oe.id as id,
                oe.code as code,
                oe."name" as name,
                oe."key" as "key"
              from objects_entity oe
              where oe.is_active = 1 and oe.id <> :id
              and oe.parent_id is null
    """, nativeQuery = true)
    List<SuMenuParentResponse> getMenuParentList(@Param("id") Long id);

    @Query(value = """
          select
            oe.id as id,
            oe.code as code,
            oe."name" as name,
            oe."key" as "key",
            oe.url as url,
            oe.icons as icons,
            oe.is_start as is_start,
            oe.is_active as is_active,
            oe.parent_id as parent_id,
            oe.type as type,
            oe.order_by as order_by
          from objects_entity oe
          where oe.id = :id
    """, nativeQuery = true)
    SuMenuDetailResponse findObjectsDetailById(@Param("id") Long id);

    Long countByCodeAndIsActive(String code, ActiveStatus activeStatus);

    Long countByCodeAndIdNotAndIsActive(String code, Long id, ActiveStatus activeStatus);
}
