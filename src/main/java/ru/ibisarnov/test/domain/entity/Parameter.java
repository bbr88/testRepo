package ru.ibisarnov.test.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "parameter_name", nullable = false)
    private String parameterName;

    @Column(name = "value")
    private String value;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "Parameter[id:" + id
                + ", parameterName:" + parameterName
                + ", value:" + (value == null ? "" : value)
                + "]";
    }
}
