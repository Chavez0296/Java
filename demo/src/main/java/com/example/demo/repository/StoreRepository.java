package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Store;


public interface StoreRepository extends JpaRepository<Store, Long> {
	Store findByName(String name);
}
