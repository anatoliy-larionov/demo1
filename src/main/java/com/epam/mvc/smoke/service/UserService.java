package com.epam.mvc.smoke.service;

import com.epam.mvc.smoke.dto.User;

public interface UserService extends BasicService<User> {
    User findUserByLogin(String login);
    User authenticateUser(User user);
}
