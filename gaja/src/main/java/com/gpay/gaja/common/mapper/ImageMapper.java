package com.gpay.gaja.common.mapper;

import com.gpay.gaja.common.dto.ImageDTO;
import com.gpay.gaja.model.domain.Image;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageMapper implements EntityToDTOMapper<Image, ImageDTO> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public Image createEntity(ImageDTO imageDTO) {
        return mapper.map(imageDTO, Image.class);
    }

    @Override
    public Image updateEntity(ImageDTO imageDTO) {
        return null;
    }

    @Override
    public ImageDTO convertToDto(Image image) {
        return mapper.map(image, ImageDTO.class);
    }

    @Override
    public List<ImageDTO> convertToDto(Iterable<Image> images) {
        List<ImageDTO> dtos = new ArrayList<ImageDTO>();
        for (Image entity : images) {
            dtos.add(convertToDto(entity));
        }
        return dtos;
    }

    @Override
    public Image convertToEntity(ImageDTO imageDTO) {
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        return mapper.map(imageDTO, Image.class);
    }

    @Override
    public List<Image> convertToEntity(Iterable<ImageDTO> imageDTOS) {
        return null;
    }
}