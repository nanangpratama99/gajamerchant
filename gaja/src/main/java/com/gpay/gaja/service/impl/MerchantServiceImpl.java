package com.gpay.gaja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gpay.gaja.common.dto.MerchantDTO;
import com.gpay.gaja.common.mapper.MerchantMapper;
import com.gpay.gaja.model.domain.Merchant;
import com.gpay.gaja.model.repository.MerchantRepository;
import com.gpay.gaja.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository repository;
    @Autowired
    private MerchantMapper mapper;

    @Override
    public MerchantDTO findById(Long id) {
        Optional<Merchant> merchantOptional = repository.findById(id);
        return mapper.convertToDto(merchantOptional.get());
    }

    @Override
    public MerchantDTO save(MerchantDTO merchantDTO) {
        return mapper.convertToDto(repository.save(mapper.convertToEntity(merchantDTO)));

    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new UsernameNotFoundException("data with ID " + id + " not found.");
        }

    }

    @Override
    public List<MerchantDTO> GetAll() {
        Iterable<Merchant> merchantOptional = repository.findAll();
        return mapper.convertToDto(merchantOptional);

    }

    @Override
    public MerchantDTO update(MerchantDTO merchantDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");

    }

    @Override
    public boolean exist(Long id) {
        // TODO Auto-generated method stub
        boolean isExist = repository.existsById(id);
        return isExist;

    }

}
