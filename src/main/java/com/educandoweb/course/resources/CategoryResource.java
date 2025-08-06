package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryService service;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> Categorys = service.findAll();
        return ResponseEntity.ok().body(Categorys);
    }
    @GetMapping(value = "/{id}")// para informar que a requisição vai aceitar um id dentro da url na hora da pesquisa
    public ResponseEntity<Category> findById(@PathVariable Long id){//@pathVariable indica que esse (Long id) vai vim pela requisição http que está logo a cima.
        Category Category = service.findById(id);
        return ResponseEntity.ok().body(Category); //.ok -> indica que ocorreu tudo bem e no body vai o resultado gerado pela requisiçao
    }
}
