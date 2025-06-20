package com.compass.springboot.services;

import com.compass.springboot.entities.User;
import com.compass.springboot.repository.UserRepository;
import com.compass.springboot.services.exceptions.DatabaseException;
import com.compass.springboot.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

        try{repository.deleteById(id);}
        catch (EmptyResultDataAccessException e) {throw new ResourceNotFoundException(id);}
        catch (DataIntegrityViolationException e) {throw new DatabaseException(e.getMessage());}
    }

    public User update(Long id, User user) {

        try {
            User entity = repository.getReferenceById(id);

            updateData(entity, user);

            return repository.save(entity);

        } catch (EntityNotFoundException e) {throw new ResourceNotFoundException(id);}
    }

    private void updateData(User entity, User user) {

        if (user.getName() != null) entity.setName(user.getName());
        if (user.getEmail() != null) entity.setEmail(user.getEmail());
        if (user.getCellphone() != null) entity.setCellphone(user.getCellphone());
    }
}
