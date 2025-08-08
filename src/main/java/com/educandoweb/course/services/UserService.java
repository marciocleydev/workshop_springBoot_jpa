package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(Long id){
        Optional<User> user =repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));// orElseThrow -> tenta da o get e se nao achar lança a excessao.
    }
    public User insert(User user){
        return repository.save(user);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);//getReferenceById nao busca diretamente no banco de dados , apenas busca um objeto monitorado pelo jpa e deixa disponivel para alteraçoes.(boa prática)
        updateData(entity,obj);
        return repository.save(entity);
    }
    private void updateData(User user, User obj){
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }


}
