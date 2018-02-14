package ru.ibisarnov.test.service.logic;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.*;
import ru.ibisarnov.test.service.domain.CategoryService;
import ru.ibisarnov.test.service.domain.ProductService;

import java.util.List;

@Component("productWriter")
public class ProductWriter implements ItemWriter<ShopDto> {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductWriter(CategoryService categoryService,
                         ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void write(List<? extends ShopDto> list) {
        if (list != null && !list.isEmpty()) {
            ShopDto shop = list.get(0);
            saveCategories(shop.getCategories().getCategory());
            saveProducts(shop.getOffers().getOffer());
        }
    }

    private void saveProducts(List<OfferDto> productDtos) {
        productService.saveAll(productDtos);
    }

    private void saveCategories(List<CategoryDto> categoryDtos) {
        categoryService.saveAll(categoryDtos);
    }

}
