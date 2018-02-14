package ru.ibisarnov.test.service.mapper;

public interface EntityDtoMapper<DTO, Entity> {
    DTO entityToDto(Entity entity);
    Entity dtoToEntity(DTO dto);
}
