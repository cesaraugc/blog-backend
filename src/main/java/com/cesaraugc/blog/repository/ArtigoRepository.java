package com.cesaraugc.blog.repository;

import com.cesaraugc.blog.model.Artigo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtigoRepository extends CrudRepository<Artigo, Long> {

    @Override
    List<Artigo> findAll();

}
