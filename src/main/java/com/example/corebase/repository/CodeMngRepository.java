package com.example.corebase.repository;

import com.example.corebase.entity.CodeMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeMngRepository extends JpaRepository<CodeMngEntity, Long> {

    @Query(value = """
        select cd_id as cdId, cd_key as cdKey , cd_name as cdName from code_mng cm where cd_category in :listCdCategory
    """, nativeQuery = true)
    List<CodeMngResponse> findByUpCdIdIn(@Param("listCdCategory") List<String> listCdCategory);

    interface CodeMngResponse {
        String getCdId();
        String getCdKey();
        String getCdName();
    }
}
