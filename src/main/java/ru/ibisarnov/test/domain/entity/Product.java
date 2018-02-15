package ru.ibisarnov.test.domain.entity;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_id", nullable = false)
    private String modelId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "price")
    private Double price;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "availability", nullable = false)
    private Boolean isAvailable;

    @Column(name = "currency", length = 3)
    private String currency;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @BatchSize(size = 20)
    @ElementCollection(targetClass = Parameter.class)
    private Set<Parameter> parameters = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @BatchSize(size = 10)
    private Set<Picture> pictures = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product[id:" + id +
                ", name:" + modelName +
                ", modelId:" + modelId +
                ", groupId:" + groupId +
                ", category:" + category +
                ", currency:" + currency +
                ", available:" + isAvailable +
                ", pictures:" + pictures.toString() +
                ", parameters:" + parameters.toString() +
                "]";
    }

}
