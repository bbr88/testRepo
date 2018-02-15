package ru.ibisarnov.test.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "source", nullable = false)
    private String source;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "Picture:[id:" + id +
                ", source:" + source
                + "]";
    }

}
