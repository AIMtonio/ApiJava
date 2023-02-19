package com.example.ApiJava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiJava.models.CategoriaModel;
import com.example.ApiJava.models.PersonaModel;
import com.example.ApiJava.repository.CategoriaRepository;
import com.example.ApiJava.repository.PersonaRepository;

@Service
public class PersonasService {
    
    @Autowired
    PersonaRepository personasRepository;

    public ArrayList<PersonaModel> obtenerPersonas(){
        return (ArrayList<PersonaModel>) personasRepository.findAll();
    }

    public PersonaModel guardarPersonas(PersonaModel persona){
        return personasRepository.save(persona);
    }

    public Optional<PersonaModel> obtenerPorId(Long id){
        return personasRepository.findById(id);
    }

    public ArrayList<PersonaModel> obtenerPorTipo(Integer tipo) {
        return personasRepository.findByTipo(tipo);
    }

    public boolean eliminarPersonas(Long id){
        try{
            personasRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
