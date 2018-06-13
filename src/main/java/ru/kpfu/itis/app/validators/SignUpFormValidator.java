package ru.kpfu.itis.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.app.forms.SignUpForm;
import ru.kpfu.itis.app.model.entities.AppUser;
import ru.kpfu.itis.app.repo.UserRepo;

import java.util.Optional;

@Component
public class SignUpFormValidator implements Validator {

    private UserRepo repo;

    public SignUpFormValidator(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SignUpForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignUpForm form = ((SignUpForm) o);

        Optional<AppUser> appUser = repo.getOneByLogin(form.getLogin());

        if (appUser.isPresent()) {
            errors.reject("bad.sign_up", "Пользователь с таким логином уже существует.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty.name", "Введите ваше ФИО");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Введите email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Введите пароль");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordRepeat", "empty.password_repeat", "Повторите пароль");

        if (!form.getPassword().equals(form.getPasswordRepeat())) {
            errors.reject("bad.sign_up", "Пароли не совпадают");
        }
    }
}
