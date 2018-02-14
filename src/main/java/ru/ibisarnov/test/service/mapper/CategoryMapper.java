package ru.ibisarnov.test.service.mapper;

import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.CategoryDto;
import ru.ibisarnov.test.domain.entity.Category;

@Component("categoryMapper")
public class CategoryMapper implements EntityDtoMapper<CategoryDto, Category> {
    @Override
    public CategoryDto entityToDto(Category category) {
        if (category != null) {
            CategoryDto dto = new CategoryDto();
            dto.setCategoryValue(category.getCategoryName());
            dto.setId(String.valueOf(category.getId()));
            return dto;
        }
        return null;
    }

    @Override
    public Category dtoToEntity(CategoryDto categoryDto) {
        if (categoryDto != null) {
            Category category = new Category();
            category.setCategoryName(categoryDto.getCategoryValue());
            category.setId(Long.parseLong(categoryDto.getId()));
            return category;
        }
        return null;
    }
}
