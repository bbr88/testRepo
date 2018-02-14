package ru.ibisarnov.test.domain.dto.element;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@XmlRootElement(name = "param")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParamDto implements Serializable {
    @XmlAttribute(name = "name")
    private String paramName;

    @XmlValue
    private String param;
}
