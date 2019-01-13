package com.epam.mvc.smoke.interceptor;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private SessionUserService sessionUserService;

    @Autowired
    public AuthInterceptor(SessionUserService sessionUserService) {
        this.sessionUserService = sessionUserService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = sessionUserService.getCurrentSessionUser();
        if (Objects.isNull(user)) {
            response.sendRedirect("/authorization");
            return false;
        }
        request.setAttribute("user", user);
        return true;
    }
}
