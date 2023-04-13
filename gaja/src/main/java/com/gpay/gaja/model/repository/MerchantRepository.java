package com.gpay.gaja.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gpay.gaja.model.domain.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long> {

    Optional<Merchant> findById(Long id);
}
