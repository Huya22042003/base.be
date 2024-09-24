package com.example.corebase.entity.cps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "CPS_SEQ_MNG")
public class CpsSeqMngEntity {

    @Id
    @Column(name = "tbl_name")
    private String tblName;

    @Column(name = "last_num")
    private BigInteger lastNum;

    @Column(name = "prefix")
    private String prefix;
}
