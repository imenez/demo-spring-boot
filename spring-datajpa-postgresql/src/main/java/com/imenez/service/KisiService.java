package com.imenez.service;


import com.imenez.dto.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface KisiService {

    KisiDto save(KisiDto kisi);

    void delete(Long id);

    List<KisiDto> getAll();

    Page<KisiDto> getAll(Pageable pageable);

    KisiDto update(KisiDto kisiDto, Long id);
}
