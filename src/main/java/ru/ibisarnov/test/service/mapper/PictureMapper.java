package ru.ibisarnov.test.service.mapper;

import org.springframework.stereotype.Component;
import ru.ibisarnov.test.domain.dto.element.PictureDto;
import ru.ibisarnov.test.domain.entity.Picture;

@Component("pictureMapper")
public class PictureMapper implements EntityDtoMapper<PictureDto, Picture> {
    @Override
    public PictureDto entityToDto(Picture picture) {
        return null;
    }

    @Override
    public Picture dtoToEntity(PictureDto pictureDto) {
        if (pictureDto != null) {
            Picture picture = new Picture();
            picture.setSource(pictureDto.getPicture());
            return picture;
        }
        return null;
    }
}
