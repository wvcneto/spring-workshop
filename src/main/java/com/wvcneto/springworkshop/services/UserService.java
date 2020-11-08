package com.wvcneto.springworkshop.services;

import com.wvcneto.springworkshop.entities.User;
import com.wvcneto.springworkshop.repositories.UserRepository;
import com.wvcneto.springworkshop.services.exceptions.DatabaseException;
import com.wvcneto.springworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user =  userRepository.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User newData) {
        User entity = userRepository.getOne(id);

        updateData(entity, newData);

        return userRepository.save(entity);
    }

    private void updateData(User entity, User newData) {
        entity.setName(newData.getName());
        entity.setEmail(newData.getEmail());
        entity.setPhone(newData.getPhone());
    }
}
