package com.epam.mvc.smoke.repository;

import com.epam.mvc.smoke.dto.User;

public interface UserRepository extends BasicRepository<User> {
    User findUserByLogin(String login);
}
