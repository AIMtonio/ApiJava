package com.example.ApiJava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiJava.models.CategoriaModel;
import com.example.ApiJava.models.ProductoModel;
import com.example.ApiJava.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/lista")
    public ResponseEntity<List<ProductoModel>> lista(){
        List<ProductoModel> lista = productoService.lista();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

}
