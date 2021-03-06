package ru.ibisarnov.test.domain.dto.element;

import lombok.Data;
import ru.ibisarnov.test.domain.dto.list.Categories;
import ru.ibisarnov.test.domain.dto.list.Currencies;
import ru.ibisarnov.test.domain.dto.list.Offers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopDto implements Serializable {
    @XmlElement(name = "currencies")
    private Currencies currencies;
    @XmlElement(name = "categories")
    private Categories categories;
    @XmlElement(name = "offers")
    private Offers offers;
}
