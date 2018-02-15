package ru.ibisarnov.test.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.OfferDto;
import ru.ibisarnov.test.domain.entity.Product;
import ru.ibisarnov.test.domain.enumeration.Currency;
import ru.ibisarnov.test.repository.CategoryRepository;

@Component("productMapper")
public class ProductMapper implements EntityDtoMapper<OfferDto, Product> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public OfferDto entityToDto(Product product) {
        return null;
    }

    @Override
    public Product dtoToEntity(OfferDto offerDto) {
        if (offerDto != null) {
            Product product = new Product();
            product.setDescription(offerDto.getDescription());
            product.setGroupId(offerDto.getGroupId());
            product.setIsAvailable(Boolean.valueOf(offerDto.getAvailable()));
            product.setCurrency(offerDto.getCurrencyId());
            product.setCategory(categoryRepository.findOne(Long.parseLong(offerDto.getCategoryId())));
            product.setModelId(offerDto.getId());
            product.setModelName(offerDto.getName());
            product.setPrice(offerDto.getPrice());
            return product;
        }
        return null;
    }
}
