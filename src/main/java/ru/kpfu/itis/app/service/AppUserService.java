package ru.kpfu.itis.app.service;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.app.forms.SignUpForm;

public interface AppUserService {

    void signUp(SignUpForm form);
}
