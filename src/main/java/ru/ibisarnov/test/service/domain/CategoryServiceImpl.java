package ru.ibisarnov.test.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ibisarnov.test.domain.dto.element.CategoryDto;
import ru.ibisarnov.test.domain.entity.Category;
import ru.ibisarnov.test.repository.CategoryRepository;
import ru.ibisarnov.test.service.mapper.EntityDtoMapper;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final EntityDtoMapper<CategoryDto, Category> categoryMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(@Qualifier("categoryMapper") EntityDtoMapper<CategoryDto, Category> categoryMapper,
                               CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void saveCategory(CategoryDto category) {
        if (category != null) {
            categoryRepository.save(categoryMapper.dtoToEntity(category));
        }
    }

    @Override
    public void saveAll(List<CategoryDto> categories) {
        if (categories != null) {
            categories.forEach(this::saveCategory);
        }
    }
}
