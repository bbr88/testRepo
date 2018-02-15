package ru.ibisarnov.test.service.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ibisarnov.test.domain.dto.element.*;
import ru.ibisarnov.test.domain.entity.Category;
import ru.ibisarnov.test.domain.entity.Product;
import ru.ibisarnov.test.service.domain.CategoryService;
import ru.ibisarnov.test.service.domain.ProductService;

import java.util.List;

import static java.lang.String.format;

@Component("productWriter")
public class ProductWriter implements ItemWriter<ShopDto> {
    private static final Logger LOG = LoggerFactory.getLogger(ProductWriter.class);

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
            printoutResults();
        }
    }

    private void saveProducts(List<OfferDto> productDtos) {
        productService.saveAll(productDtos);
    }

    private void saveCategories(List<CategoryDto> categoryDtos) {
        categoryService.saveAll(categoryDtos);
    }

    private void printoutResults() {
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();
        LOG.info(format("Got %d products and %d categories", products.size(), categories.size()));
        LOG.info("PRODUCTS:");
        products.forEach(product -> LOG.info(product.toString()));
        LOG.info("CATEGORIES:");
        categories.forEach(category -> LOG.info(category.toString()));
    }
}
