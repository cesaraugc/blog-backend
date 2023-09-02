package com.cesaraugc.blog.repository;

import com.cesaraugc.blog.model.Artigo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

}
