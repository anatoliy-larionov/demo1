package com.epam.mvc.smoke.service;

import com.epam.mvc.smoke.dto.User;

public interface SessionUserService {
    void setCurrentSessionUser(User user);
    User getCurrentSessionUser();
}
