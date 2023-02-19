package com.example.ApiJava.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiJava.models.PersonaModel;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel, Long>{

    public abstract ArrayList<PersonaModel> findByTipo(Integer tipo);

    
}
