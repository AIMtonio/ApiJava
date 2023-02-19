package com.example.ApiJava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiJava.models.ProductoModel;
import com.example.ApiJava.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    public List<ProductoModel> lista(){
        return productoRepository.listaProcedure();
    }

}
