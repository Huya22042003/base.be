package com.example.corebase.core.superAdmin.systemManagement.repository;

import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponse;
import com.example.corebase.repository.ObjectsRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("objectLoginRepository")
public interface SuMenuLoginRepository extends ObjectsRepository {

    @Query(value = """
        select
            o.id,
            o.code,
            o.name,
            o.key,
            o.url,
            o.icons,
            o.parent_id ,
             fn_code_name(o."type") as "type",
            o.order_by
        from objects_entity o
        join user_object uo on uo.object_id = o.id
        join users u on u.id = uo.user_id
        where o.type = 'OBJECT_TYPE_1'
        and u.full_name = :fullName
        and o.is_active = 1
        and o.is_start = 1
        and uo.is_active = 1
        """, nativeQuery = true)
    List<SuMenuLoginResponse> getAllMenuLoginResponse(@Param("fullName") String fullName);
}
