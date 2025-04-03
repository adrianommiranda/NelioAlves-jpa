package com.secao22_266.secao22_266.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secao22_266.secao22_266.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
