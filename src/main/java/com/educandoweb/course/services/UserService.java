package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DataBaseIntegrityException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));// orElseThrow -> tenta da o get e se nao achar lança a excessao.
    }

    public User insert(User user) {
        return repository.save(user);
    }

    // primeiro tentar capturar a excessao que está sendo gerada no spring e nao no Hibernate pois assim o sistema fica menos dependente de uma implementaçao expecifica.
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e ){
            throw new DataBaseIntegrityException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);//getReferenceById nao busca diretamente no banco de dados , apenas busca um objeto monitorado pelo jpa e deixa disponivel para alteraçoes.(boa prática)
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }


}
