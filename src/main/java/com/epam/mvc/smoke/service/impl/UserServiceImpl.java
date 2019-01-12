package com.epam.mvc.smoke.service.impl;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.repository.UserRepository;
import com.epam.mvc.smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByLogin(String login) {
        return this.userRepository.findUserByLogin(login);
    }

    @Override
    public User authenticateUser(User user) {
        User foundUser = userRepository.findUserByLogin(user.getLogin());
        if (foundUser != null && !foundUser.getPassword().equals(user.getPassword())) {
            return null;
        }
        return foundUser;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void add(User user) {
        this.userRepository.add(user);
    }

    @Override
    public void delete(long id) {
        this.userRepository.delete(id);
    }
}
