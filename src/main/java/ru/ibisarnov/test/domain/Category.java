package ru.ibisarnov.test.domain;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @BatchSize(size = 150)
    private Set<Product> products = new HashSet<>();

}
