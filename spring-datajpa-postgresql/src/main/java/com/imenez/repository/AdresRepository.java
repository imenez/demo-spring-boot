package com.imenez.repository;

import com.imenez.entity.Adres;
import com.imenez.entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdresRepository extends JpaRepository<Adres, Long> {

    @Query("SELECT u FROM Adres u WHERE u.kisi = :kisi")
    List<Adres> findByKisiId(@Param("kisi") Kisi kisi);



}
