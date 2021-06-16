package com.newsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsApp.entities.Categorie;
import com.newsApp.entities.New;

public interface NewRepository extends JpaRepository<New, Long> {
  
	List<New> findByCategorie(Categorie cat);
	
}
