package com.newsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsApp.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
