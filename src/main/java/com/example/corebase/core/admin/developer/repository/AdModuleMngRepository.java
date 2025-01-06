package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.core.admin.developer.model.request.AdModuleFilterRequest;
import com.example.corebase.core.admin.developer.model.response.AdModuleResponse;
import com.example.corebase.entity.cps.CpsModuleMngEntity;
import com.example.corebase.repository.cps.CpsModuleMngRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdModuleMngRepository extends CpsModuleMngRepository {

    @Query(value = """
                SELECT
                    m.id as id,
                    m.name as name,
                    m.code as code,
                    FN_GET_CODE_NAME(m.use_yn) as useYn
                FROM CPS_MODULE_MNG m
                WHERE m.del_yn = :#{#req.delYn}
                    AND (:#{#req.code} IS NULL OR m.code LIKE CONCAT('%', :#{#req.code}, '%'))
                    AND (:#{#req.name} IS NULL OR m.name LIKE CONCAT('%', :#{#req.name}, '%'))
                    AND (:#{#req.useYn} IS NULL OR m.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
            """, countQuery = """
                SELECT
                    m.id as id
                FROM CPS_MODULE_MNG m
                WHERE m.del_yn = :#{#req.delYn}
                    AND (:#{#req.code} IS NULL OR m.code LIKE CONCAT('%', :#{#req.code}, '%'))
                    AND (:#{#req.name} IS NULL OR m.name LIKE CONCAT('%', :#{#req.name}, '%'))
                    AND (:#{#req.useYn} IS NULL OR m.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
            """, nativeQuery = true)
    Page<AdModuleResponse> getPageModule(@Param("req") AdModuleFilterRequest req, Pageable pageable);

    List<CpsModuleMngEntity> findByDelYnOrderByCreatedDate(String delYn);
}
