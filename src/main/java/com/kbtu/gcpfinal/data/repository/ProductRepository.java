package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
