package com.gpay.gaja.service.impl;

import com.gpay.gaja.common.dto.ImageDTO;
import com.gpay.gaja.common.mapper.ImageMapper;
import com.gpay.gaja.model.domain.Image;
import com.gpay.gaja.model.domain.Merchant;
import com.gpay.gaja.model.repository.ImageRepository;
import com.gpay.gaja.model.repository.MerchantRepository;
import com.gpay.gaja.service.ImageService;
import com.gpay.gaja.util.ImageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepo;

    @Autowired
    private MerchantRepository repository;

    @Autowired
    private ImageMapper mapper;

    public Image uploadImage(MultipartFile file, Long idOwner) throws IOException {
        Optional<Merchant> merchantsOptional = repository.findById(idOwner);

        Merchant merchantsz = new Merchant();
        merchantsz.setId(merchantsOptional.get().getId());
        merchantsz.setEmail(merchantsOptional.get().getEmail());
        merchantsz.setKontakPemBis(merchantsOptional.get().getKontakPemBis());
        merchantsz.setNamaPemBis(merchantsOptional.get().getNamaPemBis());
        merchantsz.setKontakPemBis(merchantsOptional.get().getKontakPemBis());
        merchantsz.setBrand(merchantsOptional.get().getBrand());
        merchantsz.setEmailBis(merchantsOptional.get().getEmailBis());
        merchantsz.setKota(merchantsOptional.get().getKota());
        merchantsz.setKodePos(merchantsOptional.get().getKodePos());
        merchantsz.setKategoriMerch(merchantsOptional.get().getKategoriMerch());
        merchantsz.setJmlhMerch(merchantsOptional.get().getJmlhMerch());
        merchantsz.setAlamat(merchantsOptional.get().getAlamat());
        merchantsz.setFKtp(merchantsOptional.get().getFKtp());
        merchantsz.setFSelfie(merchantsOptional.get().getFSelfie());
        merchantsz.setFLogo(merchantsOptional.get().getFLogo());
        merchantsz.setFMerchant(merchantsOptional.get().getFMerchant());
        merchantsz.setBank(merchantsOptional.get().getBank());
        merchantsz.setNamaPemRek(merchantsOptional.get().getNamaPemRek());
        merchantsz.setNoRek(merchantsOptional.get().getNoRek());

        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setImageData(ImageUtil.compressImage(file.getBytes()));
        image.setMerchantsId(merchantsz);

        return imageRepo.save(image);
    }

    public byte[] downloadImage(String fileName) {
        Optional<Image> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }

    @Override
    public List<ImageDTO> GetAll() {
        Iterable<Image> imageIterable = imageRepo.findAll();
        List<Image> imageList = new ArrayList<>();

        imageIterable.forEach(imageList::add);
        List<ImageDTO> imageDTOS = new ArrayList<>();

        for (Image image : imageList) {
            ImageDTO images = mapper.convertToDto(image);

            Merchant merchantsz = new Merchant();
            merchantsz.setId(image.getMerchantsId().getId());
            merchantsz.setEmail(image.getMerchantsId().getEmail());
            merchantsz.setKontakPemBis(image.getMerchantsId().getKontakPemBis());
            merchantsz.setNamaPemBis(image.getMerchantsId().getNamaPemBis());
            merchantsz.setKontakPemBis(image.getMerchantsId().getKontakPemBis());
            merchantsz.setBrand(image.getMerchantsId().getBrand());
            merchantsz.setEmailBis(image.getMerchantsId().getEmailBis());
            merchantsz.setKota(image.getMerchantsId().getKota());
            merchantsz.setKodePos(image.getMerchantsId().getKodePos());
            merchantsz.setKategoriMerch(image.getMerchantsId().getKategoriMerch());
            merchantsz.setJmlhMerch(image.getMerchantsId().getJmlhMerch());
            merchantsz.setAlamat(image.getMerchantsId().getAlamat());
            merchantsz.setFKtp(image.getMerchantsId().getFKtp());
            merchantsz.setFSelfie(image.getMerchantsId().getFSelfie());
            merchantsz.setFLogo(image.getMerchantsId().getFLogo());
            merchantsz.setBank(image.getMerchantsId().getBank());
            merchantsz.setNamaPemRek(image.getMerchantsId().getNamaPemRek());
            merchantsz.setNoRek(image.getMerchantsId().getNoRek());

            images.setMerchantsz(merchantsz);
            imageDTOS.add(images);
        }
        return imageDTOS;
    }

}