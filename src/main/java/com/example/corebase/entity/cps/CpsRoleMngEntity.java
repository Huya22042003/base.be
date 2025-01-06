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
@Table(name = "CPS_ROLE_MNG")
public class CpsRoleMngEntity extends PrimaryBase {

    // admin ( supper admin - staff pending ) // user
    private String code;

    private String name;

    private String note;

    private String useYn;
}
