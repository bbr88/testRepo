package ru.ibisarnov.test.domain.dto.list;

import lombok.Data;
import ru.ibisarnov.test.domain.dto.element.OfferDto;

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
