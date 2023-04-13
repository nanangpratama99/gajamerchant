package com.gpay.gaja.common.dto;

import org.springframework.web.multipart.MultipartFile;

import com.gpay.gaja.model.domain.Merchant;

import lombok.Data;

@Data
public class ImageDTO {

    private Long id;
    private Long merchantsId;

    private String name;
    private String type;
    private MultipartFile imageData;

    private Merchant merchantsz;
}