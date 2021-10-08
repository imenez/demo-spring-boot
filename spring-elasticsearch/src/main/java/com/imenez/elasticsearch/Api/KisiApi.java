package com.imenez.elasticsearch.Api;


import com.imenez.elasticsearch.Entity.Kisi;
import com.imenez.elasticsearch.Repo.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/kisi")
@RestController
public class KisiApi {

    @Autowired
    private KisiRepository kisiRepository;

    @PostMapping("/ekle")
    public ResponseEntity<Kisi> kisiEkle(@RequestBody Kisi kisi){

        return ResponseEntity.ok(kisiRepository.save(kisi));
    }

    @GetMapping("/tumunuListele")
    public ResponseEntity<Iterable<Kisi>> tumunuListele(){

        return ResponseEntity.ok(kisiRepository.findAll());
    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getByCustomQuery(@PathVariable String search){

        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);

        //List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search,search);

        return ResponseEntity.ok(kisiler);
    }
}
