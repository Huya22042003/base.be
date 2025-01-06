package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.response.AdMenuMngResponse;
import com.example.corebase.entity.cps.CpsMenuMngEntity;
import com.example.corebase.repository.cps.CpsMenuMngRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdMenuMngRepository extends CpsMenuMngRepository {

    @Query(value = """
                SELECT 
                    m.id as id,
                    m.name as name,
                    parent.name as parent,
                    mo.name as module,
                    m.use_yn as useYnCd,
                    m.url as url,
                    FN_GET_CODE_NAME(m.use_yn) as useYn
                FROM CPS_MENU_MNG m
                LEFT JOIN CPS_MENU_MNG parent on m.parent_id = parent.id AND parent.del_yn = :#{#req.delYn}
                LEFT JOIN CPS_MODULE_MNG mo on m.module = mo.id AND mo.del_yn = :#{#req.delYn}
                WHERE m.del_yn = :#{#req.delYn}
                    AND (:#{#req.url} IS NULL OR m.url LIKE CONCAT('%', :#{#req.url}, '%'))
                    AND (:#{#req.name} IS NULL OR m.name LIKE CONCAT('%', :#{#req.name}, '%'))
                    AND (:#{#req.module} IS NULL OR mo.name LIKE CONCAT('%', :#{#req.module}, '%'))
            """, countQuery = """
                        SELECT
                            m.id as id
                        FROM CPS_MENU_MNG m
                        LEFT JOIN CPS_MENU_MNG parent on m.parent_id = parent.id AND parent.del_yn = :#{#req.delYn}
                        LEFT JOIN CPS_MODULE_MNG mo on m.module = mo.id AND mo.del_yn = :#{#req.delYn}
                        WHERE m.del_yn = :#{#req.delYn}
                            AND (:#{#req.url} IS NULL OR m.url LIKE CONCAT('%', :#{#req.url}, '%'))
                            AND (:#{#req.name} IS NULL OR m.name LIKE CONCAT('%', :#{#req.name}, '%'))
                            AND (:#{#req.module} IS NULL OR mo.name LIKE CONCAT('%', :#{#req.module}, '%'))
            """, nativeQuery = true)
    Page<AdMenuMngResponse> getPageMenu(@Param("req") AdMenuFilterRequest req, Pageable pageable);

    List<CpsMenuMngEntity> findByDelYnOrderByCreatedDate(String delYn);
}
