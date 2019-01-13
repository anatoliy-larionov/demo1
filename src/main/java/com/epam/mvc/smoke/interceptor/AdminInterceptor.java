package com.epam.mvc.smoke.interceptor;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.dto.enums.Role;
import com.epam.mvc.smoke.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    private SessionUserService sessionUserService;

    @Autowired
    public AdminInterceptor(SessionUserService sessionUserService) {
        this.sessionUserService = sessionUserService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = sessionUserService.getCurrentSessionUser();
        if (Objects.isNull(user) || !user.getRole().equals(Role.ADMIN)) {
            response.sendRedirect("/");
            return false;
        }
        request.setAttribute("user", user);
        return true;
    }
}
