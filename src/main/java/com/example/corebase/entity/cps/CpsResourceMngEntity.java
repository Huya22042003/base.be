package com.example.corebase.entity.cps;

import com.example.corebase.entity.base.PrimaryBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "CPS_RESOURCE_MNG")
public class CpsResourceMngEntity extends PrimaryBase {

    private String api;

    private String name;

    private String role;

    private String type;

    private String useYn;

    private String module;

    private String method;
}
