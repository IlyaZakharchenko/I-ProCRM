package ru.kpfu.itis.app.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {

    private String login;
    private String name;
    private String password;
    private String passwordRepeat;
    private MultipartFile image;
}
