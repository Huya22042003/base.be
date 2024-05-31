package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Table(name = "role_object")
public class RoleObjectEntity extends PrimaryBase {

    @ManyToOne
    @JoinColumn(name = "object_id")
    private ObjectsEntity objectsEntityId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity rolesEntityId;

}
