package ru.ibisarnov.test.domain.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement(name = "currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyDto implements Serializable {
    @XmlAttribute(name = "id")
    private String id;
}
