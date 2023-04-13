package com.gpay.gaja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gpay.gaja.common.dto.MerchantDTO;

public interface MerchantService {
    MerchantDTO findById(Long id);

    MerchantDTO save(MerchantDTO merchantDTO);

    void delete(Long id);

    List<MerchantDTO> GetAll();

    MerchantDTO update(MerchantDTO merchantsDTO);

    boolean exist(Long id);
}
