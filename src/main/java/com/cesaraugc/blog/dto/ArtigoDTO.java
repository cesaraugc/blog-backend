package com.cesaraugc.blog.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cesaraugc.blog.model.Artigo;

public class ArtigoDTO {
    public long id;
    public String titulo;
    public String texto;

    public ArtigoDTO(Artigo artigo) {
        id = artigo.getId();
        titulo = artigo.getTitulo();
        texto = artigo.getTexto();
    }

    public static List<ArtigoDTO> converter(List<Artigo> artigos) {
        return artigos.stream().map(ArtigoDTO::new).collect(Collectors.toList());
    }
}
