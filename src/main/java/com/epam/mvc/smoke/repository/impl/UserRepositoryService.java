package com.epam.mvc.smoke.repository.impl;

import com.epam.mvc.smoke.data.UserData;
import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.repository.UserRepository;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryService implements UserRepository {
    private UserData userData = new UserData();

    @Override
    public User findUserByLogin(String login) {
        try {
            return this.userData.getUserList()
                    .stream()
                    .filter(user -> user.getLogin().equals(login))
                    .findAny()
                    .orElse(null);
        }catch (EmptyResultDataAccessException ignored) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return this.userData.getUserList();
    }

    @Override
    public User update(User o) {
        return null;
    }

    @Override
    public User findById(long id) {
        return this.userData.getUserList()
                .stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void add(User user) {
        this.userData.getUserList().add(user);
    }

    @Override
    public void delete(long id) {
        this.userData.getUserList()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .map(user -> {
                    this.userData.getUserList().remove(user);
                    return user;
                });
    }
}
