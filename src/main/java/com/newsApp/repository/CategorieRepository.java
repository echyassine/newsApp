package com.newsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsApp.entities.Categorie;
import com.newsApp.entities.New;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
  
	Categorie findByName(String name);
	
}
