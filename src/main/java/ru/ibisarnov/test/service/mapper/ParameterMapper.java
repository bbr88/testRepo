package ru.ibisarnov.test.service.mapper;

import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.ParamDto;
import ru.ibisarnov.test.domain.entity.Parameter;

@Component("parameterMapper")
public class ParameterMapper implements EntityDtoMapper<ParamDto, Parameter> {
    @Override
    public ParamDto entityToDto(Parameter parameter) {
        return null;
    }

    @Override
    public Parameter dtoToEntity(ParamDto paramDto) {
        if (paramDto != null) {
            Parameter parameter = new Parameter();
            parameter.setParameterName(paramDto.getParamName());
            parameter.setValue(paramDto.getParam());
            return parameter;
        }
        return null;
    }
}
