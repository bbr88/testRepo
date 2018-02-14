package ru.ibisarnov.test.domain.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDto implements Serializable {
    @XmlAttribute(name = "id")
    private String id;
    @XmlValue
    private String categoryValue;
}
