package com.newsApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newsApp.entities.Categorie;
import com.newsApp.service.ICategorieService;

@RestController
class CategorieController {
  @Autowired
  ICategorieService CategorieService;

  @PostMapping("/Categories")
  public Categorie addCategorie(@RequestBody Categorie Categorie) {
    return CategorieService.addCategorie(Categorie);
  }

  @GetMapping("/Categories")
  public List<Categorie> getCategories(){
    return CategorieService.getCategories();
  }

  @GetMapping("/Categories/{id}")
  public Optional<Categorie> getCategorie(@PathVariable Long id) {
    return CategorieService.getCategorie(id);
  }

  @DeleteMapping("/Categories/{id}")
  public Boolean deleteCategorie(@PathVariable Long id) {
    return CategorieService.deleteCategorie(id);
  }



}
