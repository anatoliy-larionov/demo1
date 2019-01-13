package com.epam.mvc.smoke.data;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.dto.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<User> userList = new ArrayList<>();

    public UserData() {
        userList.add(new User(0, "Anatolii", "Larionov", "login", "password",
                Role.ADMIN));
        userList.add(new User(1,  "Ivan", "Larionov", "login1", "password",
                Role.USER));
    }

    public List<User> getUserList() {
        return userList;
    }
}
