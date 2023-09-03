package com.cesaraugc.blog.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<?> getById(@PathVariable long id) {
        Optional<Artigo> artigo = artigoService.getById(id);
        if (artigo.isPresent()) {
            ArtigoDTO artigoDTO = new ArtigoDTO(artigo.get());
            return new ResponseEntity<>(artigoDTO, HttpStatus.OK);
        }
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("status", HttpStatus.NOT_FOUND.value());
        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Artigo saveArtigo(@RequestBody Artigo artigo) {
        artigoService.save(artigo);
        return artigo;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        Optional<Artigo> artigo = artigoService.getById(id);
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (artigo.isPresent()) {
            artigoService.deleteById(id);
            map.put("message", "Record is deleted successfully!");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
