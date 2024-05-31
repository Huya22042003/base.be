package com.example.corebase.repository;

import com.example.corebase.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {
    static final String BASE_NAME = "users_repository";

    @Query("SELECT u FROM UsersEntity u WHERE LOWER(u.userName) LIKE LOWER(CONCAT('%', :username, '%'))")
    Optional<UsersEntity> getClientByUserName(@Param("username") String username);
}
