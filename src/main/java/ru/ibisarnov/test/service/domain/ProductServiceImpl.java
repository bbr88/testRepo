package ru.ibisarnov.test.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ibisarnov.test.domain.dto.element.OfferDto;
import ru.ibisarnov.test.domain.dto.element.ParamDto;
import ru.ibisarnov.test.domain.dto.element.PictureDto;
import ru.ibisarnov.test.domain.entity.Parameter;
import ru.ibisarnov.test.domain.entity.Picture;
import ru.ibisarnov.test.domain.entity.Product;
import ru.ibisarnov.test.repository.ParameterRepository;
import ru.ibisarnov.test.repository.PictureRepository;
import ru.ibisarnov.test.repository.ProductRepository;
import ru.ibisarnov.test.service.mapper.EntityDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final EntityDtoMapper<ParamDto, Parameter> parameterMapper;
    private final EntityDtoMapper<PictureDto, Picture> pictureMapper;
    private final EntityDtoMapper<OfferDto, Product> productMapper;
    private final ParameterRepository parameterRepository;
    private final ProductRepository productRepository;
    private final PictureRepository pictureRepository;

    @Autowired
    public ProductServiceImpl(@Qualifier("parameterMapper") EntityDtoMapper<ParamDto, Parameter> parameterMapper,
                              @Qualifier("pictureMapper") EntityDtoMapper<PictureDto, Picture> pictureMapper,
                              @Qualifier("productMapper") EntityDtoMapper<OfferDto, Product> productMapper,
                              ParameterRepository parameterRepository,
                              PictureRepository pictureRepository,
                              ProductRepository productRepository) {
        this.parameterRepository = parameterRepository;
        this.pictureRepository = pictureRepository;
        this.productRepository = productRepository;
        this.parameterMapper = parameterMapper;
        this.pictureMapper = pictureMapper;
        this.productMapper = productMapper;
    }

    @Override
    public void saveProduct(OfferDto product) {
        if (product != null) {
            Product newProduct = productMapper.dtoToEntity(product);
            List<Parameter> parameters = product.getParams()
                    .stream()
                    .map(parameterMapper::dtoToEntity)
                    .collect(Collectors.toList());
            List<Picture> pictures = product.getPictures()
                    .stream()
                    .map(pictureMapper::dtoToEntity)
                    .collect(Collectors.toList());
            Product finalNewProduct = productRepository.save(newProduct);
            parameters.forEach(parameter -> parameter.setProduct(finalNewProduct));
            pictures.forEach(picture -> picture.setProduct(finalNewProduct));
            parameterRepository.save(parameters);
            pictureRepository.save(pictures);
        }
    }

    @Override
    public void saveAll(List<OfferDto> products) {
        products.forEach(this::saveProduct);
    }
}
