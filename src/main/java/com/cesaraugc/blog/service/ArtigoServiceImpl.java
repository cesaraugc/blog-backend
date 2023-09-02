package com.cesaraugc.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesaraugc.blog.model.Artigo;
import com.cesaraugc.blog.repository.ArtigoRepository;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    ArtigoRepository artigoRepository;

    @Override
    public List<Artigo> getAll() {
        return this.artigoRepository.findAll();
    }

    @Override
    public void save(Artigo artigo) {
        this.artigoRepository.save(artigo);
    }

    @Override
    public Artigo getById(long id) {
        return this.artigoRepository.getReferenceById(id);
    }

    @Override
    public void deleteById(long id) {
        this.artigoRepository.deleteById(id);
    }

}
