package com.example.corebase.core.admin.contentMng.repository;

import com.example.corebase.core.admin.contentMng.model.dto.AdBannerConDTO;
import com.example.corebase.core.admin.contentMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.contentMng.model.response.AdBannerResponse;
import com.example.corebase.repository.BannerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdBannerRepository extends BannerRepository {

    @Query(value = """
        SELECT 
            * 
        FROM banner b
        WHERE b.del_yn = :#{#con.delYn}
        AND b.banner_type = 
    """, nativeQuery = true)
    Page<AdBannerResponse> getPageAdBanner(@Param("req") AdBannerFilterReq req, @Param("con") AdBannerConDTO con, Pageable pageable);
}
