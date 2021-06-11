package com.newsApp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsApp.entities.Categorie;
import com.newsApp.repository.CategorieRepository;


@Service
@Transactional
public class CategorieServiceImpl implements ICategorieService {
  @Autowired
  CategorieRepository categorieRepository;

  @Override
  public Categorie addCategorie(Categorie c) {
    return categorieRepository.save(c);
  }

  @Override
  public List<Categorie> getCategories() {
    return categorieRepository.findAll();
  }

  @Override
  public Optional<Categorie> getCategorie(Long id) {
    return categorieRepository.findById(id);
  }

  @Override
  public Boolean deleteCategorie(Long id) {
    categorieRepository.deleteById(id);
    return !categorieRepository.existsById(id);
  }

}
