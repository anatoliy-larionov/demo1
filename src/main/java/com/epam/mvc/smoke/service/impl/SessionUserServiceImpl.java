package com.epam.mvc.smoke.service.impl;

import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.service.SessionUserService;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope(proxyMode = ScopedProxyMode.INTERFACES)
@Component
public class SessionUserServiceImpl implements SessionUserService {

    private User currentSessionUser;

    @Override
    public void setCurrentSessionUser(User user) {
        this.currentSessionUser = user;
    }

    @Override
    public User getCurrentSessionUser() {
        return this.currentSessionUser;
    }
}
