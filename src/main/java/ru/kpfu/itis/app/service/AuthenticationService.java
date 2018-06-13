package ru.kpfu.itis.app.service;

import org.springframework.security.core.Authentication;
import ru.kpfu.itis.app.model.entities.AppUser;

public interface AuthenticationService {
    AppUser getUserByAuth(Authentication authentication);
}
