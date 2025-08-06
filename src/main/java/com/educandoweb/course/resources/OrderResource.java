package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;
import com.educandoweb.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> Orders = service.findAll();
        return ResponseEntity.ok().body(Orders);
    }
    @GetMapping(value = "/{id}")// para informar que a requisição vai aceitar um id dentro da url na hora da pesquisa
    public ResponseEntity<Order> findById(@PathVariable Long id){//@pathVariable indica que esse (Long id) vai vim pela requisição http que está logo a cima.
        Order Order = service.findById(id);
        return ResponseEntity.ok().body(Order); //.ok -> indica que ocorreu tudo bem e no body vai o resultado gerado pela requisiçao
    }
}
