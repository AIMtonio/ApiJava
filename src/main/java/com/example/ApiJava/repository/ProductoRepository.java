package com.example.ApiJava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiJava.models.CategoriaModel;
import com.example.ApiJava.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{

    @Query(value = "{call sp_get_productos()}", nativeQuery = true)
    List<ProductoModel> listaProcedure();
    
}
