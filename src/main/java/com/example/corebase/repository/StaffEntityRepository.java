package com.example.corebase.repository;

import com.example.corebase.entity.StaffEntity;
import com.example.corebase.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StaffEntityRepository extends JpaRepository<StaffEntity, UUID> {
    static final String BASE_NAME = "staff_repository";

    @Query("SELECT u FROM StaffEntity u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))")
    Optional<StaffEntity> getClientByUserName(@Param("username") String username);
}
