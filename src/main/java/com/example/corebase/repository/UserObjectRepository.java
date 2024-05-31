package com.example.corebase.repository;

import com.example.corebase.entity.UserObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserObjectRepository extends JpaRepository<UserObjectEntity, UUID> {
    static final String BASE_NAME = "user_object_repository";
}
