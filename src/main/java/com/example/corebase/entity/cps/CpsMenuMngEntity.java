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
@Table(name = "CPS_MENU_MNG")
public class CpsMenuMngEntity extends PrimaryBase {

    private String url;

    private String icon;

    private String name;

    private String parentId;

    private String useYn;

    private String module;

    private String orderBy;

    private String keyLang;

    private String type;
}
