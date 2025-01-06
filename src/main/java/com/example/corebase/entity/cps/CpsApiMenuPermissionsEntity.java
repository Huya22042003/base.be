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
@Table(name = "CPS_API_MENU_PERMISSION")
public class CpsApiMenuPermissionsEntity extends PrimaryBase {

    private String menuId;

    private String apiId;

    private String permissionId;

    // is menu - is api
    private String type;
}
