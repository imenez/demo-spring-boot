package com.imenez.controller;


import com.imenez.dto.KisiDto;
import com.imenez.service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
public class KisiController {

    @Autowired
    private KisiService kisiService;


    @PostMapping("/ekle")
    public ResponseEntity<KisiDto> save(@RequestBody KisiDto kisiDto){



        return ResponseEntity.ok(kisiService.save(kisiDto));
    }


    @GetMapping("/tumunuGetir")
    public ResponseEntity<List<KisiDto>> getAll(){



        return ResponseEntity.ok(kisiService.getAll());
    }


    @DeleteMapping("/sil/{id}")
    public void delete(@PathVariable Long id){

        kisiService.delete(id);
    }

    @PutMapping("/update/{id}")
    public KisiDto update(@RequestBody KisiDto kisiDto, @PathVariable Long id){

        return kisiService.update(kisiDto, id);
    }
}
