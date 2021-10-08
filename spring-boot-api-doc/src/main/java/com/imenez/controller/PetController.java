package com.imenez.controller;


import com.imenez.entity.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "My Pet Swagger Doc")
public class PetController {


    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        Date date = new Date();
        Pet pet = new Pet();

        pet.setId(1);
        pet.setName("firsty pet");
        pet.setDate(date);
        petList.add(pet);
    }

    @ApiOperation(value = "Getting All Pets", notes = "All Pets getting")
    @GetMapping("/getAll")
    public ResponseEntity<List<Pet>> tumunuListele(){


        return ResponseEntity.ok(petList);
    }

    @ApiOperation(value = "Adding New Pet", notes = "Pet adding")
    @PostMapping("/save")
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "petty") Pet pet){

        petList.add(pet);

        return ResponseEntity.ok(pet);
    }
}
