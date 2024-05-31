package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesObjectDetailRequest;
import com.example.corebase.entity.RoleObjectEntity;
import com.example.corebase.repository.RoleObjectRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("suRoleObjectManagementRepository")
public interface SuRoleObjectManagementRepository extends RoleObjectRepository {

    @Query(value = """
        SELECT ro.object_id as idObject, oe.parent_id as idParent FROM role_object ro join objects_entity oe on ro.object_id = oe.id 
        where ro.is_active = 1 and oe.is_active = 1
        and ro.role_id = :idRole
    """, nativeQuery = true)
    List<SuRolesObjectDetailRequest> getRoleObjectDetail(@Param("idRole") UUID idRole);

    @Query(value = """
        SELECT ro.* FROM role_object ro 
        where ro.role_id = :idRole
    """, nativeQuery = true)
    List<RoleObjectEntity> getAllRoleObjectByRoleId(@Param("idRole") UUID idRole);
}
