package com.compass.springboot.services;

import com.compass.springboot.entities.User;
import com.compass.springboot.repository.UserRepository;
import com.compass.springboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        return repository.findAll();
    };

    public User findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {

        return repository.save(user);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public User update(Long id, User user) {

        User entity = repository.getReferenceById(id);

        updateData(entity, user);

        return repository.save(entity);
    }

    private void updateData(User entity, User user) {

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setCellphone(user.getCellphone());
    }
}
