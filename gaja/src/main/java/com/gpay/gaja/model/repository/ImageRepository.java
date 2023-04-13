package com.gpay.gaja.model.repository;

import com.gpay.gaja.model.domain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    Optional<Image> findById(Long id);

    Optional<Image> findByName(String fileName);
}