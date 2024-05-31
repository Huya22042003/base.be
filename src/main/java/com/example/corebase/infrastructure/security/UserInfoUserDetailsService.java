package com.example.corebase.infrastructure.security;

import com.example.corebase.entity.StaffEntity;
import com.example.corebase.entity.UsersEntity;
import com.example.corebase.infrastructure.constant.KeyModule;
import com.example.corebase.repository.StaffEntityRepository;
import com.example.corebase.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private StaffEntityRepository staffEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.endsWith(KeyModule.MODULE_CLIENT)) {
            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_CLIENT.length());
            Optional<UsersEntity> userInfo = usersRepository.getClientByUserName(trimmedUsername.trim());
            return userInfo.map(CustomUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + trimmedUsername));
        }

        if (username.endsWith(KeyModule.MODULE_ADMIN)) {
            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_ADMIN.length());
            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());
            return userInfo.map(CustomUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + trimmedUsername));
        }

        if (username.endsWith(KeyModule.MODULE_STAFF)) {
            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_STAFF.length());
            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());
            return userInfo.map(CustomUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + trimmedUsername));
        }
        return null;
    }

}