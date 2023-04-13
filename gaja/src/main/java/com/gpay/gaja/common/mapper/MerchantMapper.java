package com.gpay.gaja.common.mapper;

import com.gpay.gaja.common.dto.MerchantDTO;
import com.gpay.gaja.model.domain.Merchant;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MerchantMapper implements EntityToDTOMapper<Merchant, MerchantDTO> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public Merchant createEntity(MerchantDTO merchantDTO) {
        return mapper.map(merchantDTO, Merchant.class);
    }

    @Override
    public Merchant updateEntity(MerchantDTO merchantDTO) {
        return null;
    }

    @Override
    public MerchantDTO convertToDto(Merchant merchant) {
        return mapper.map(merchant, MerchantDTO.class);
    }

    @Override
    public List<MerchantDTO> convertToDto(Iterable<Merchant> merchantss) {
        List<MerchantDTO> dtos = new ArrayList<MerchantDTO>();
        for (Merchant entity : merchantss) {
            dtos.add(convertToDto(entity));
        }
        return dtos;
    }

    @Override
    public Merchant convertToEntity(MerchantDTO merchantDTO) {
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        return mapper.map(merchantDTO, Merchant.class);
    }

    @Override
    public List<Merchant> convertToEntity(Iterable<MerchantDTO> merchantDTOS) {
        return null;
    }
}