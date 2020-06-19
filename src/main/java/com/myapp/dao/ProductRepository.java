package com.myapp.dao;

import com.myapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "products")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
