package com.example.ApiJava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiJava.models.CategoriaModel;
import com.example.ApiJava.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaModel> lista(){
        return categoriaRepository.listaProcedure();
    }

    public ArrayList<CategoriaModel> obtenerCategorias(){
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    public CategoriaModel guardarCategoria(CategoriaModel categoria){
        return categoriaRepository.save(categoria);
    }

    public CategoriaModel guardarPersonas(CategoriaModel categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<CategoriaModel> obtenerPorId(Long id){
        return categoriaRepository.findById(id);
    }

    /*public ArrayList<CategoriaModel> obtenerPorTipo(Integer tipo) {
        return categoriaRepository.findByTipo(tipo);
    }*/

    public boolean eliminarCategorias(Long id){
        try{
            categoriaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }



}
