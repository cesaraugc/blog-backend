package com.cesaraugc.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cesaraugc.blog.dto.ArtigoDTO;
import com.cesaraugc.blog.model.Artigo;
import com.cesaraugc.blog.service.ArtigoService;

@RestController("/artigos")
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @GetMapping()
    public List<ArtigoDTO> getAll() {
        List<Artigo> artigos = artigoService.getAll();
        return ArtigoDTO.converter(artigos);
    }

    @GetMapping("/{id}")
    public ArtigoDTO getById(@PathVariable long id) {
        Artigo artigo = artigoService.getById(id);
        return new ArtigoDTO(artigo);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        artigoService.deleteById(id);
    }

    @PostMapping()
    public Artigo saveArtigo(@RequestBody Artigo artigo) {
        artigoService.save(artigo);
        return artigo;
    }
}
