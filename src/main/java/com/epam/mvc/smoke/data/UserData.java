package com.epam.mvc.smoke.data;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.dto.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        userList.add(new User("Anatolii", "Larionov", "login", "password",
                Role.ADMIN));
        userList.add(new User( "Ivan", "Larionov", "login1", "password",
                Role.USER));
        return userList;
    }
}
