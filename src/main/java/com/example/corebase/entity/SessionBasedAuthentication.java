package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "session_based_authentication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SessionBasedAuthentication extends PrimaryBase {

    @Column(name = "id_user")
    private UUID idUser;

    @Column(name = "time_start")
    private Long timeStart;

    @Column(name = "time_end")
    private Long timeEnd;

    @Column(name = "status")
    private ActiveStatus status;

    @Column(name = "type_session")
    private String typeSession;
}
