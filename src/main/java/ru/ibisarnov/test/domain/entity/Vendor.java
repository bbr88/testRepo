package ru.ibisarnov.test.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "vendor_code")
    private String vendorCode;
}

