package com.myapp.dao;

import com.myapp.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "providers")
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
