package ru.ibisarnov.test.service.domain;

import ru.ibisarnov.test.domain.dto.element.OfferDto;

import java.util.List;

public interface ProductService {
    void saveProduct(OfferDto product);
    void saveAll(List<OfferDto> products);
}
