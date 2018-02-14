package ru.ibisarnov.test.domain.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Data
@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDto implements Serializable {

    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "group_id")
    private String groupId;

    @XmlAttribute(name = "available")
    private String available;

    @XmlElement(name = "price")
    private Double price;

    @XmlElement(name = "currencyId")
    private String currencyId;

    @XmlElement(name = "categoryId")
    private String categoryId;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "picture")
    private List<PictureDto> pictures;

    @XmlElement(name = "param")
    private List<ParamDto> params;

    @XmlElement(name = "stock")
    private Integer stock;
}
