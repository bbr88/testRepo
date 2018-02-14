package ru.ibisarnov.test.domain.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Data
@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Offers implements Serializable {
    private List<OfferDto> offer;
}
