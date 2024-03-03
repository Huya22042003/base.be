package com.example.corebase.repository;

import com.example.corebase.entity.ObjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectsRepository extends JpaRepository<ObjectsEntity, Long> {
    static final String BASE_NAME = "objects_repository";

    @Query(value = """
        SELECT o.* FROM objectsEntity o join user_object uo on o.id = uo.object_id 
        where uo.user_id = :idUser AND o.type = 0 
        AND o.is_active = 1
        AND uo.is_active = 1
        order by order_by;
    """, nativeQuery = true)
    List<ObjectsEntity> getObjectsByIdUsers(@Param("idUser") Long idUser);
}
