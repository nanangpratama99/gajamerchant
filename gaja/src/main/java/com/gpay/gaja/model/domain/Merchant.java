package com.gpay.gaja.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_pemilik_bisnis")
    private String namaPemBis;
    @Column(name = "kontak_pemilik_bisnis")
    private String kontakPemBis;
    @Column(name = "email")
    private String email;
    @Column(name = "npwp")
    private String npwp;
    @Column(name = "nama_brand")
    private String brand;
    @Column(name = "email_bisnis")
    private String emailBis;
    @Column(name = "kota")
    private String kota;
    @Column(name = "kode_pos")
    private String kodePos;
    @Column(name = "kategori_merchant")
    private String kategoriMerch;
    @Column(name = "jumlah_merchant")
    private String jmlhMerch;
    @Column(name = "alamat_bisnis")
    private String alamat;
    @Column(name = "foto_ktp")
    private String fKtp;
    @Column(name = "foto_selfie")
    private String fSelfie;
    @Column(name = "foto_logo")
    private String fLogo;
    @Column(name = "foto_merchant")
    private String fMerchant;
    @Column(name = "jenis_bank")
    private String bank;
    @Column(name = "nama_pemilik_rekening")
    private String namaPemRek;
    @Column(name = "no_rekening")
    private String noRek;

    @JsonIgnore
    @OneToMany(mappedBy = "merchantsId")
    private List<Image> images;
}
