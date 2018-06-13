package ru.kpfu.itis.app.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.app.forms.SignUpForm;
import ru.kpfu.itis.app.model.entities.AppUser;
import ru.kpfu.itis.app.model.enums.AccessRight;
import ru.kpfu.itis.app.repo.UserRepo;
import ru.kpfu.itis.app.service.AppUserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class AppUserServiceImpl implements AppUserService {

    private UserRepo repo;

    private PasswordEncoder encoder;

    @Value("${CLOUDINARY_URL}")
    private String CLOUDINARY_URL;

    public AppUserServiceImpl(UserRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void signUp(SignUpForm form) {
        String url = null;
        try {
            MultipartFile image = form.getImage();
            if (image != null) {
                Map uploadResult;
                Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
                uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                url = uploadResult.get("url").toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppUser newUser = AppUser.builder()
                .imageUrl(url)
                .login(form.getLogin())
                .name(form.getName())
                .password(encoder.encode(form.getPassword()))
                .role(AccessRight.GUEST)
                .build();
        repo.save(newUser);
    }
}
