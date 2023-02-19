package com.example.ApiJava.controllers;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiJava.models.CategoriaModel;
import com.example.ApiJava.models.PersonaModel;
import com.example.ApiJava.services.CategoriaService;
import com.example.ApiJava.services.PersonasService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    PersonasService personasService;

    @GetMapping()
    public ArrayList<PersonaModel> obtenerPersonas(){
        return personasService.obtenerPersonas();
    }

    @PostMapping()
    public PersonaModel guardarPersonas(@RequestBody PersonaModel persona){
        return this.personasService.guardarPersonas(persona);
    }

    @GetMapping( path = "/{id}")
    public Optional <PersonaModel>  obtenerPorId(@PathVariable("id") Long id){
        return this.personasService.obtenerPorId(id); 
    }

    @GetMapping("/query")
    public ArrayList<PersonaModel> obtenerUsuarioPorPrioridad(@RequestParam("tipo") Integer tipo){
        return this.personasService.obtenerPorTipo(tipo);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPersonas(@PathVariable("id") Long id){
        boolean ok = this.personasService.eliminarPersonas(id);
        if (ok){
            return "Se eliminó la persona con id " + id;
        }else{
            return "No se pudo eliminar la persona con id " + id;
        }
    }


}
