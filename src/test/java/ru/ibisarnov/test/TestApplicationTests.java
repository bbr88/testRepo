package ru.ibisarnov.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ibisarnov.test.domain.dto.*;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    private static final String TEST_YML = "<yml_catalog date=\"2016-11-19 07:35\">\n" +
            "<shop>\n" +
            "<currencies>\n" +
            "<currency id=\"RUR\"/>\n" +
            "<currency id=\"USD\"/>\n" +
            "<currency id=\"EUR\"/>\n" +
            "</currencies>\n" +
            "<categories>\n" +
            "<category id=\"10102\">amazon test items</category>\n" +
            "<category id=\"10103\">Матрешки</category>\n" +
            "<category id=\"10101\">ebay test items</category>\n" +
            "<category id=\"10104\">Тест категория</category>\n" +
            "<category id=\"10105\">1</category>\n" +
            "<category id=\"10106\">2</category>\n" +
            "<category id=\"10107\">3</category>\n" +
            "<category id=\"10108\">4car</category>\n" +
            "</categories>\n" +
            "<offers>\n" +
            "<offer id=\"1234567890_01\" group_id=\"1234567890\" available=\"false\">\n" +
            "<price>1236</price>\n" +
            "<currencyId>RUB</currencyId>\n" +
            "<categoryId>10103</categoryId>\n" +
            "<name>Товары  2 шт - первый</name>\n" +
            "<picture>http://soviet.market/upload/img/orient/720-580/DB05001T.jpg</picture>\n" +
            "<description>опсиание123 йцуйцу</description>\n" +
            "<param name=\"свойство\">01</param>\n" +
            "</offer>\n" +
            "<offer id=\"1234567890_02\" group_id=\"1234567890\" available=\"false\">\n" +
            "<price>1235</price>\n" +
            "<currencyId>RUB</currencyId>\n" +
            "<categoryId>10103</categoryId>\n" +
            "<name>Товары - 2 шт - второй</name>\n" +
            "<picture>http://soviet.market/upload/img/orient/720-580/DB05001T.jpg</picture>\n" +
            "<picture>https://static-eu.insales.ru/images/products/1/303/97370415/casio-ef-539d-1a2_2.jpg</picture>\n" +
            "<picture>https://static-eu.insales.ru/images/products/1/300/97370412/ef-539d-1a9-2-1000x1000.jpg</picture>\n" +
            "<picture>https://static-eu.insales.ru/images/products/1/302/97370414/1732934-2.jpg</picture>" +
            "<description>опсиание </description>\n" +
            "<param name=\"свойство\">02</param>\n" +
            "</offer>\n" +
            "</offers>\n" +
            "</shop>\n" +
            "</yml_catalog>";

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
