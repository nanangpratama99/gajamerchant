package com.gpay.gaja.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpay.gaja.common.dto.MerchantDTO;
import com.gpay.gaja.model.repository.MerchantRepository;
import com.gpay.gaja.service.MerchantService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/merchant")
public class MerchantController {

    @Autowired
    MerchantService service;

    @Autowired
    MerchantRepository repo;

    @GetMapping
    public ResponseEntity<MerchantDTO> findById(@RequestParam Long id) {
        MerchantDTO dto = service.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MerchantDTO> save(@RequestBody MerchantDTO merchantDTO) {
        MerchantDTO dto = service.save(merchantDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody MerchantDTO merchantDTO) {
        Long id = merchantDTO.getId();
        if (service.exist(id)) {
            MerchantDTO dto = service.save(merchantDTO);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data dengan ID " + id + " tidak ditemukan");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {

            service.delete(id);
            return ResponseEntity.ok("Data dengan ID " + id + " berhasil dihapus");

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data dengan ID " + id + " tidak ditemukan");
        } catch (Exception e) {
            String code = e.toString();
            int newCode = code.length();
            System.out.println(newCode);

            if (newCode == 217) {
                return ResponseEntity.status(HttpStatus.FOUND)
                        // 302
                        .body("Table Merchant dengan Merchants Id: " + id + " masih ada");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Terjadi kesalahan saat menghapus data dengan ID " + id + ": " + e.getMessage());
            }
        }
    }

    @GetMapping("/getAll")
    public List<MerchantDTO> GetAll() {
        List<MerchantDTO> dto = service.GetAll();
        return dto;
    }
}
