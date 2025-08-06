package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }
    @GetMapping(value = "/{id}")// para informar que a requisição vai aceitar um id dentro da url na hora da pesquisa
    public ResponseEntity<User> findById(@PathVariable Long id){//@pathVariable indica que esse (Long id) vai vim pela requisição http que está logo a cima.
        User user = service.findById(id);
        return ResponseEntity.ok().body(user); //.ok -> indica que ocorreu tudo bem e no body vai o resultado gerado pela requisiçao
    }
}
