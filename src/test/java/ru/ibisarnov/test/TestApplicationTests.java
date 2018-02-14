package ru.ibisarnov.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ibisarnov.test.domain.dto.element.CurrencyDto;
import ru.ibisarnov.test.domain.dto.element.ShopDto;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testYmlShouldBeParsed() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(ShopDto.class, CurrencyDto.class);
        marshaller.setMarshallerProperties(new HashMap<String, Object>() {{
            put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});
        try {
            ShopDto shopDto = (ShopDto) marshaller.unmarshal(new StreamSource(
                    new FileInputStream(new ClassPathResource("yml_test_new.xml").getFile())));
            List<CurrencyDto> currencyDtoList = shopDto.getCurrencies().getCurrency();
            currencyDtoList.get(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
