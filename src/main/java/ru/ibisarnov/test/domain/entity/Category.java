package ru.ibisarnov.test.domain.entity;

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
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 150)
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "Category[id:" + id
                + ", categoryName:" + categoryName
                + "]";
    }
}
