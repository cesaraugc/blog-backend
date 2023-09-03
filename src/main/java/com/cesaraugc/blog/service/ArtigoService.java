package com.cesaraugc.blog.service;

import java.util.List;
import java.util.Optional;

import com.cesaraugc.blog.model.Artigo;

public interface ArtigoService {
    List<Artigo> getAll();

    void save(Artigo artigo);

    Optional<Artigo> getById(long id);

    void deleteById(long id);
}
