package com.imenez.elasticsearch.Repo;

import com.imenez.elasticsearch.Entity.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String> {


    //@Query("{\"bool\" : {\"must\" : [ {\"match\" : {\"ad\" : \"?0\"}}, {\"field\" : {\"soyad\" : \"?1\"}} ]}}\"")
    @Query("{\"bool\" : {\"must\" : [ {\"match\" : {\"ad\" : \"?0\"}} ]}}\"")
    List<Kisi> getByCustomQuery(String search);

    //List<Kisi> findByAdLikeOrSoyadLike(String ad, String soyad);
}
