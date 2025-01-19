package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.core.admin.developer.model.dto.AdMenuConDTO;
import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.response.AdMenuResponse;
import com.example.corebase.entity.system.SysMenuEntity;
import com.example.corebase.repository.system.SysMenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdMenuRepository extends SysMenuRepository {

    @Query(value = """
        SELECT 
            m.menuId,
            FN_GET_CODE_NAME(m.siteType) as siteType,
            m.nm,
            m.useYn,
            parent.nm as parent
        FROM menu m 
        LEFT JOIN menu parent ON m.parentId = parent.menuId AND parent.delYn = :#{#con.delYn}
        WHERE m.delYn = :#{#con.delYn}
        AND (:#{#req.siteType} IS NULL OR m.siteType LIKE CONCAT('%', :#{#req.siteType}, '%'))
        AND (:#{#req.nm} IS NULL OR m.nm LIKE CONCAT('%', :#{#req.nm}, '%'))
        AND (:#{#req.parentId} IS NULL OR m.parentId LIKE CONCAT('%', :#{#req.parentId}, '%'))
        AND (:#{#req.useYn} IS NULL OR m.useYn LIKE CONCAT('%', :#{#req.useYn}, '%'))
    """, nativeQuery = true)
    Page<AdMenuResponse> getPageData(@Param("req")AdMenuFilterRequest req, @Param("con")AdMenuConDTO con, Pageable pageable);

    Optional<SysMenuEntity> findByMenuIdAndDelYn(String menuId, String delYn);

    List<SysMenuEntity> findByParentIdIsNullAndDelYn(String delYn);
}
