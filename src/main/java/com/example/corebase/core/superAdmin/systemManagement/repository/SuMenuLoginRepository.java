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
        join object_element_group oeg on o.id = oeg.object_id
        join object_groups og on og.id = oeg.object_group_id
        join staff_object_group sog on sog.id = sog.object_group_id
        join staff_entity se on se.id = sog.staff_id
        where o.type = 'OBJECT_TYPE_1'
        and se.username = :fullName
        and o.is_active = 1
        and o.is_start = 1
        and se.is_active = 1
        """, nativeQuery = true)
    List<SuMenuLoginResponse> getAllMenuLoginResponse(@Param("fullName") String fullName);
}
