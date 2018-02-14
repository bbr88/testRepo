package ru.ibisarnov.test.service.mapper;

import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.CurrencyDto;
import ru.ibisarnov.test.domain.enumeration.Currency;

@Component("currencyMapper")
public class CurrencyMapper implements EntityDtoMapper<CurrencyDto, Currency> {
    @Override
    public CurrencyDto entityToDto(Currency currency) {
        if (currency != null) {
            CurrencyDto dto = new CurrencyDto();
            dto.setId(currency.name());
            return dto;
        }
        return null;
    }

    @Override
    public Currency dtoToEntity(CurrencyDto currencyDto) {
        if (currencyDto != null) {
            return Currency.valueOf(currencyDto.getId());
        }
        return null;
    }
}
