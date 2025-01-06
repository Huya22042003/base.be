package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.entity.cps.CpsApiMenuPermissionsEntity;
import com.example.corebase.repository.cps.CpsApiMenuPermissionsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdApiMenuPermissionsRepository extends CpsApiMenuPermissionsRepository {

    List<CpsApiMenuPermissionsEntity> findByIdNotInAndDelYn(List<String> listId, String delYn);

    List<CpsApiMenuPermissionsEntity> findByPermissionIdAndDelYn(String permission, String delYn);
}
