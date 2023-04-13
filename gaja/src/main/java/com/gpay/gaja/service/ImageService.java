package com.gpay.gaja.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gpay.gaja.common.dto.ImageDTO;
import com.gpay.gaja.model.domain.Image;

public interface ImageService {

    Image uploadImage(MultipartFile file, Long idOwner) throws IOException;

    byte[] downloadImage(String fileName);

    List<ImageDTO> GetAll();

}