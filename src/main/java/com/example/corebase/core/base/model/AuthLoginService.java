package com.example.corebase.core.base.model;

import com.example.corebase.entity.Users;

public interface AuthLoginService {

    Long getIdUser();

    String getName();

    String getEmail();

    String getUserName();

    String getPicture();

    Users getAuth();

}
