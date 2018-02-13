package ru.ibisarnov.test.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "parameter_name", nullable = false, unique = true)
    private String parameterName;

    @Column(name = "value")
    private String value;

    @Column(name = "product", nullable = false)
    private Product product;

}
