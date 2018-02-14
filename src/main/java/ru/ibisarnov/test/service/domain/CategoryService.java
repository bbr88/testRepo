package ru.ibisarnov.test.service.domain;

import ru.ibisarnov.test.domain.dto.element.CategoryDto;

import java.util.List;

public interface CategoryService {
    void saveCategory(CategoryDto category);
    void saveAll(List<CategoryDto> categories);
}
