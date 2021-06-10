package com.newsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsApp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
