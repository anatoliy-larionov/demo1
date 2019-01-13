package com.epam.mvc.smoke.controller;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.exceptions.UserAlreadyExistsException;
import com.epam.mvc.smoke.service.SessionUserService;
import com.epam.mvc.smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final SessionUserService sessionUserService;
    private final UserService userService;

    @Autowired
    public RegistrationController(SessionUserService sessionUserService, UserService userService) {
        this.sessionUserService = sessionUserService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String authentication() {
        return "registration";
    }

    @PostMapping("/registration")
    public String authentication(User user) throws UserAlreadyExistsException {
        for(User foundUser : userService.findAll()){
            if (foundUser.getLogin().equals(user.getLogin()))
                throw new UserAlreadyExistsException("Пользователь с таким именем уже существует");
        }
        userService.add(user);
        sessionUserService.setCurrentSessionUser(user);
        return "redirect:";
    }
}
