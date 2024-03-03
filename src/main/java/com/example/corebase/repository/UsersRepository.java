package com.example.corebase.repository;

import com.example.corebase.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    static final String BASE_NAME = "users_repository";
}
