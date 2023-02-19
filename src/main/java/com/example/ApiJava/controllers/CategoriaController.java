package com.example.ApiJava.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiJava.models.CategoriaModel;
import com.example.ApiJava.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/lista")
    public ResponseEntity<List<CategoriaModel>> lista(){
        List<CategoriaModel> lista = categoriaService.lista();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping()
    public ArrayList<CategoriaModel> obtenerCategorias(){
        return categoriaService.obtenerCategorias();
    }

    @PostMapping()
    public CategoriaModel guardarCategorias(@RequestBody CategoriaModel categoria){
        return this.categoriaService.guardarCategoria(categoria);
    }

    @GetMapping( path = "/{id}")
    public Optional <CategoriaModel>  obtenerPorId(@PathVariable("id") Long id){
        return this.categoriaService.obtenerPorId(id); 
    }

    /*@GetMapping("/query")
    public ArrayList<CategoriaModel> obtenerUsuarioPorPrioridad(@RequestParam("tipo") Integer tipo){
        return this.categoriaService.obtenerPorTipo(tipo);
    }*/

    @DeleteMapping(path = "/{id}")
    public String eliminarCategorias(@PathVariable("id") Long id){
        boolean ok = this.categoriaService.eliminarCategorias(id);
        if (ok){
            return "Se eliminó la persona con id " + id;
        }else{
            return "No se pudo eliminar la persona con id " + id;
        }
    }

}
