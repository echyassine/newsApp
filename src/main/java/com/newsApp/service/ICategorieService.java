package com.newsApp.service;

import java.util.List;
import java.util.Optional;

import com.newsApp.entities.Categorie;


public interface ICategorieService {
  Categorie addCategorie(Categorie c);
  List<Categorie> getCategories();
  Optional<Categorie> getCategorie(Long id);
  Boolean deleteCategorie(Long id);
}
