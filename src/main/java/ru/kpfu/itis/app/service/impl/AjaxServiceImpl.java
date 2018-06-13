package ru.kpfu.itis.app.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.forms.FacebookSignForm;
import ru.kpfu.itis.app.forms.SignUpForm;
import ru.kpfu.itis.app.model.entities.AppUser;
import ru.kpfu.itis.app.model.enums.AccessRight;
import ru.kpfu.itis.app.repo.UserRepo;
import ru.kpfu.itis.app.service.AjaxService;

import java.util.Optional;

@Service
public class AjaxServiceImpl implements AjaxService {

    private UserRepo repo;

    private PasswordEncoder encoder;

    public AjaxServiceImpl(UserRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public AppUser signInFacebook(FacebookSignForm form) {
        Optional<AppUser> user = repo.getOneByUid(form.getUid());
        if (!user.isPresent()) {
           AppUser appUser = AppUser.builder()
                   .role(AccessRight.GUEST)
                   .login(form.getEmail())
                   .name(form.getDisplayName())
                   .imageUrl(form.getPhotoUrl())
                   .uid(form.getUid())
                   .password(encoder.encode(form.getUid()))
                   .build();
           repo.save(appUser);
           return appUser;
        }
        return user.get();
    }
}
