package com.newsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsApp.entities.New;

public interface NewRepository extends JpaRepository<New, Long> {

}
