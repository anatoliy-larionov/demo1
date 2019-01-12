package com.epam.mvc.smoke.dto;

import com.epam.mvc.smoke.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private long id;
    private String nameFirst;
    private String nameLast;
    private String login;
    private String password;
    private Role role;

    public User() {
    }

    public User(String nameFirst, String nameLast, String login, String password, Role role) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
