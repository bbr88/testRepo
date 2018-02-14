package ru.ibisarnov.test.config;

import org.hibernate.SessionFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.ibisarnov.test.domain.dto.element.ShopDto;
import ru.ibisarnov.test.domain.entity.Product;

import javax.persistence.EntityManagerFactory;

import java.util.HashMap;

import static ru.ibisarnov.test.config.ConfigConstants.BatchConstants.PRODUCT_ROOT;
import static ru.ibisarnov.test.config.ConfigConstants.BatchConstants.YML_PATH_PROPERTY;

@Configuration
public class XmlJobConfiguration {

    private final EntityManagerFactory factory;

    @Autowired
    public XmlJobConfiguration(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(ShopDto.class);
        marshaller.setMarshallerProperties(new HashMap<String, Object>() {{
            put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});
        return marshaller;
    }

    @Bean
    ItemReader<Product> xmlFileProductReader(Environment env) {
        StaxEventItemReader<Product> productFileReader = new StaxEventItemReader<>();
        productFileReader.setResource(new ClassPathResource(env.getRequiredProperty(YML_PATH_PROPERTY)));
        productFileReader.setFragmentRootElementName(PRODUCT_ROOT);

        Jaxb2Marshaller productMarshaller = new Jaxb2Marshaller();
        productMarshaller.setClassesToBeBound(Product.class);

        productFileReader.setUnmarshaller(productMarshaller);
        return productFileReader;
    }

    @Bean
    ItemWriter<Product> productItemWriter() {
        HibernateItemWriter<Product> hibernateProductWriter = new HibernateItemWriter<>();
        hibernateProductWriter.setSessionFactory(factory.unwrap(SessionFactory.class));
        //todo

        return hibernateProductWriter;
    }
}
