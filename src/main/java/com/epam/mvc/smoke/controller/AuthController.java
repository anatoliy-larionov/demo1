package com.epam.mvc.smoke.controller;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.exceptions.UserNotFoundException;
import com.epam.mvc.smoke.service.SessionUserService;
import com.epam.mvc.smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    private SessionUserService sessionUserService;
    private UserService userService;

    @Autowired
    public AuthController(SessionUserService sessionUserService, UserService userService) {
        this.sessionUserService = sessionUserService;
        this.userService = userService;
    }

    @GetMapping("/authorization")
    public String authorization() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public ModelAndView authorization(ModelAndView modelAndView, User user) throws UserNotFoundException {
        User foundUser = userService.authenticateUser(user);
        if (foundUser != null) {
            sessionUserService.setCurrentSessionUser(foundUser);
            modelAndView.setViewName("redirect:");
        }else {
            throw new UserNotFoundException("Неверный логин или пароль!");
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "redirect:authorization";
    }
}
