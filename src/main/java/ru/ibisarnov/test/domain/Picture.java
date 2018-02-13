package ru.ibisarnov.test.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "source", nullable = false, unique = true)
    private String source;

    @ManyToOne
    private Product product;

}
