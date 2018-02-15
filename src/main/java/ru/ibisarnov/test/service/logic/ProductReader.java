package ru.ibisarnov.test.service.logic;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.ShopDto;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;

@Component("productReader")
public class ProductReader implements ItemReader<ShopDto> {

    private final Jaxb2Marshaller marshaller;

    @Value("${yml.path}")
    private String ymlFilename;
    private boolean read = false;

    @Autowired
    public ProductReader(Jaxb2Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    @Override
    public ShopDto read() throws Exception {
        if (read) {
            return null;
        }
        ShopDto shop;
        shop = (ShopDto) marshaller
                .unmarshal(new StreamSource(new FileInputStream(new ClassPathResource(ymlFilename).getFile())));
        read = true;
        return shop;
    }
}
