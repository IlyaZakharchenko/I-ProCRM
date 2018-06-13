package ru.kpfu.itis.app.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.model.entities.AppUser;
import ru.kpfu.itis.app.model.userDetails.UserDetailsImpl;
import ru.kpfu.itis.app.repo.UserRepo;
import ru.kpfu.itis.app.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepo repo;

    public AuthenticationServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public AppUser getUserByAuth(Authentication authentication) {
        UserDetailsImpl currentUserDetails = (UserDetailsImpl) authentication.getPrincipal();
        AppUser currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        return repo.getOne(currentUserId);
    }
}
