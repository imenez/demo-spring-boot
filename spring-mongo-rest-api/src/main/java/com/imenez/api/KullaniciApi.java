package com.imenez.api;

import com.imenez.entity.Kullanici;
import com.imenez.repo.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostMapping("/ekle")
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){

        return ResponseEntity.ok(kullaniciRepository.save(kullanici));

    }

    @GetMapping("/tumunuListele")
    public ResponseEntity<List<Kullanici>> tumunuListele(){

        return ResponseEntity.ok(kullaniciRepository.findAll());

    }
}
