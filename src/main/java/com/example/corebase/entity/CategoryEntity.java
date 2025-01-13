package com.example.corebase.entity;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryEntity extends AuditEntity implements Serializable {

    @Id
    private String categorySeq;

    private String categoryType;

    private String categoryNm;

    private String useYn;
}
