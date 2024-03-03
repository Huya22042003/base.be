package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.response.MenuLoginResponse;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("objectLoginRepository")
public interface MenuLoginRepository extends ObjectsRepository {

    @Query(value = """
        select
            o.id,
            o.code,
            o.name,
            o.key,
            o.url,
            o.parent_id ,
            o.order_by
        from objectsEntity o
        join user_object uo on uo.object_id = o.id
        join usersEntity u on u.id = uo.user_id
        where type = 0
        and u.full_name = :fullName
        and o.is_active = 1
        and uo.is_active = 1
        and u.id = 1
        """, nativeQuery = true)
    List<MenuLoginResponse> getAllMenuLoginResponse(@Param("fullName") String fullName);
}
