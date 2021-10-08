package com.imenez.dto;


import lombok.Data;

import java.util.List;

@Data
public class KisiDto {

    private Long id;

    private String ad;

    private String soyad;


    private List<String> adresList;

}
