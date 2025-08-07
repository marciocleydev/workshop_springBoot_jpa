package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> Products = service.findAll();
        return ResponseEntity.ok().body(Products);
    }
    @GetMapping(value = "/{id}")// para informar que a requisição vai aceitar um id dentro da url na hora da pesquisa
    public ResponseEntity<Product> findById(@PathVariable Long id){//@pathVariable indica que esse (Long id) vai vim pela requisição http que está logo a cima.
        Product Product = service.findById(id);
        return ResponseEntity.ok().body(Product); //.ok -> indica que ocorreu tudo bem e no body vai o resultado gerado pela requisiçao
    }
}
