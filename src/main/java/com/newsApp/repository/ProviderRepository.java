package com.newsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsApp.entities.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
