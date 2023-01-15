package com.neff.service;

import com.neff.exceptions.UserErrorException;
import com.neff.model.User;
import com.neff.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserErrorException("USER NOT FOUND");
        }
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate (User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserErrorException("USER NOT FOUND");
        }
        userRepository.deleteById(id);
    }

}
