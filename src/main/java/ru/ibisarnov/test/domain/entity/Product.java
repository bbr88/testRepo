package ru.ibisarnov.test.domain.entity;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import ru.ibisarnov.test.domain.enumeration.Currency;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_id", nullable = false, unique = true)
    private String modelId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "description")
    private String description;

    @Column(name = "availability", nullable = false)
    private Boolean isAvailable;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private Currency currency;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @BatchSize(size = 20)
    @ElementCollection(targetClass = Parameter.class)
    private Set<Parameter> parameters = new HashSet<>();

    /**
     * Even though the same pictures might be representing different models,
     * I don't like an idea having the m-t-m relation here.
     * Therefore, leaving it as-is due to both simplicity and laziness:)
     * <p>
     * The relation itself might be implemented via @JoinTable with both joinColumn and inverseJoinColumn
     */
    @OneToMany(mappedBy = "product")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @BatchSize(size = 10)
    private Set<Picture> pictures = new HashSet<>();

}
