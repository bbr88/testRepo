package ru.ibisarnov.test.domain.dto.list;

import ru.ibisarnov.test.domain.dto.element.CategoryDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories implements Serializable {

    private List<CategoryDto> category;

    public List<CategoryDto> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryDto> category) {
        this.category = category;
    }
}
