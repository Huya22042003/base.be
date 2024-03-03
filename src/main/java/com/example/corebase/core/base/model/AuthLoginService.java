package com.example.corebase.core.base.model;

import com.example.corebase.entity.UsersEntity;

public interface AuthLoginService {

    Long getIdUser();

    String getName();

    String getEmail();

    String getUserName();

    String getPicture();

    UsersEntity getAuth();

}
