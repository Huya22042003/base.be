package com.example.corebase.core.common.service;

import com.example.corebase.core.common.service.dto.LoginRequest;
import com.example.corebase.core.common.service.dto.RegisterRequest;
import com.example.corebase.entity.StaffEntity;
import com.example.corebase.entity.UsersEntity;
import com.example.corebase.infrastructure.constant.KeyModule;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.infrastructure.security.CustomUserDetails;
import com.example.corebase.infrastructure.tokenCustom.ObjectsDto;
import com.example.corebase.infrastructure.tokenCustom.PremiumDto;
import com.example.corebase.infrastructure.tokenCustom.TokenDto;
import com.example.corebase.infrastructure.tokenCustom.TokenUtils;
import com.example.corebase.repository.StaffEntityRepository;
import com.example.corebase.repository.UsersRepository;
import com.example.corebase.util.LanguageCommon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private StaffEntityRepository staffEntityRepository;

    public String adminLogin(LoginRequest request) {
        request.setUsername(request.getUsername() + KeyModule.MODULE_ADMIN);
        return authLogin(request);
    }

    public String clientLogin(LoginRequest request) {
        request.setUsername(request.getUsername() + KeyModule.MODULE_CLIENT);
        return authLogin(request);
    }

    public String staffLogin(LoginRequest request) {
        request.setUsername(request.getUsername() + KeyModule.MODULE_STAFF);
        return authLogin(request);
    }

    public String authLogin(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = tokenUtils.generateToken(getAuthConvertToken(authentication));

            return token;
        } catch (Exception e) {
            // Xử lý lỗi đăng nhập không thành công
            e.printStackTrace();
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.login.error"));
        }
    }

    public TokenDto getAuthConvertToken(Authentication authentication) {
        TokenDto tokenDto = new TokenDto();

        String username = authentication.getName();

        if (username.endsWith(KeyModule.MODULE_CLIENT)) {
            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_CLIENT.length());
            Optional<UsersEntity> userInfo = usersRepository.getClientByUserName(trimmedUsername.trim());

            PremiumDto premium = new PremiumDto();

            return userInfo.map(userEntity -> new TokenDto(userEntity, premium))
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        }

        if (username.endsWith(KeyModule.MODULE_ADMIN)) {
            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_ADMIN.length());
            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());

            ObjectsDto objectsDto = new ObjectsDto();

            return userInfo.map(userEntity -> new TokenDto(userEntity, objectsDto))
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        }

        if (username.endsWith(KeyModule.MODULE_STAFF)) {
            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_STAFF.length());
            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());

            ObjectsDto objectsDto = new ObjectsDto();

            return userInfo.map(userEntity -> new TokenDto(userEntity, objectsDto))
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        }
        return tokenDto;
    }

    @Transactional
    public UsersEntity registerRequest(RegisterRequest request) {
        UsersEntity entity = new UsersEntity();
        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        entity.setPhone(request.getPhone());
        entity.setUserName(request.getUsername());

        return usersRepository.save(entity);
    }
}
