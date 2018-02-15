package ru.ibisarnov.test.service.domain;

import ru.ibisarnov.test.domain.dto.element.CategoryDto;
import ru.ibisarnov.test.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    void saveCategory(CategoryDto category);
    void saveAll(List<CategoryDto> categories);
    List<Category> findAll();
}
