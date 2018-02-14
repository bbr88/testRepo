package ru.ibisarnov.test.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibisarnov.test.repository.*;

@Service
public class ParserServiceImpl implements ParserService {

    private final ParameterRepository parameterRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PictureRepository pictureRepository;
    private final VendorRepository vendorRepository;

    @Autowired
    public ParserServiceImpl(ParameterRepository parameterRepository,
                             CategoryRepository categoryRepository,
                             ProductRepository productRepository,
                             PictureRepository pictureRepository,
                             VendorRepository vendorRepository) {
        this.parameterRepository = parameterRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.pictureRepository = pictureRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void parseDocument() {
        //read item
        //process item, i.e. create respective entities
        //if read items quantity >= ? then write items to db

    }
}
