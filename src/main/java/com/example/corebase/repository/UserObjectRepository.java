package com.example.corebase.repository;

import com.example.corebase.entity.UserObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserObjectRepository extends JpaRepository<UserObject, Long> {
    static final String BASE_NAME = "user_object_repository";
}
