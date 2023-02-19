package com.example.ApiJava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiJava.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaModel, Long>{

    @Query(value = "{call sp_get_categorias()}", nativeQuery = true)
    List<CategoriaModel> listaProcedure();

    
    
}
