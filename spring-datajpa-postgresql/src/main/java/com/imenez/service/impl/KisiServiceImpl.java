package com.imenez.service.impl;

import com.imenez.dto.KisiDto;
import com.imenez.entity.Adres;
import com.imenez.entity.Kisi;
import com.imenez.repository.AdresRepository;
import com.imenez.repository.KisiRepository;
import com.imenez.service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Service
public class KisiServiceImpl implements KisiService {


    @Autowired
    private KisiRepository kisiRepository;
    @Autowired
    private AdresRepository adresRepository;

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Assert.notNull(kisiDto.getAd(), "Ad required.. ");

        Kisi kisi = new Kisi();

        kisi.setAd(kisiDto.getAd());
        kisi.setSoyad(kisiDto.getSoyad());

        Kisi kisiDb = kisiRepository.save(kisi);

        List<Adres> adresList = new ArrayList<>();
        kisiDto.getAdresList().forEach(adresIndex -> {
            Adres adres = new Adres();
            adres.setAdres(adresIndex);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            adresList.add(adres);
        });
        adresRepository.saveAll(adresList);

        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

        kisiRepository.deleteById(id);

    }

    @Override
    public List<KisiDto> getAll() {

        List<Kisi> kisiList = kisiRepository.findAll();

        List<KisiDto> kisiDtoList =  new ArrayList<>();

        kisiList.forEach(kisiIndex -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(kisiIndex.getId());
            kisiDto.setAd(kisiIndex.getAd());
            kisiDto.setSoyad(kisiIndex.getSoyad());
            kisiDto.setAdresList(kisiIndex.getAdresList().stream().map(Adres::getAdres)
                    .collect(Collectors.toList()));

            kisiDtoList.add(kisiDto);
        });

        return kisiDtoList;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public KisiDto update(KisiDto kisiDto, Long id) {

        Kisi kisi = kisiRepository.findById(id).get();
        kisi.setAd(kisiDto.getAd());
        kisi.setSoyad(kisiDto.getSoyad());

        List<Adres> adresList = adresRepository.findByKisiId(kisi);

        List<Adres> adresTempList = new ArrayList<>();

        for(String s : kisiDto.getAdresList()){
            Adres adres = new Adres();
            adres.setAdres(s);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adresTempList.add(adres);
        }



        adresList.forEach(adres -> {
            adres.setAktif(false);
        });
        adresRepository.saveAll(adresList);

        adresList.addAll(adresTempList);
        adresRepository.saveAll(adresList);


        kisi.setAdresList(adresList);
        kisiRepository.save(kisi);


        kisiDto.setId(id);


        return kisiDto;
    }
}
