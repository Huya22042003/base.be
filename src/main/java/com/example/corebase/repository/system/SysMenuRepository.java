package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenuEntity, String> {
}
