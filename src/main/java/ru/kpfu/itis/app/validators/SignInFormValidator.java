package ru.kpfu.itis.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.app.forms.SignInForm;
import ru.kpfu.itis.app.model.entities.AppUser;
import ru.kpfu.itis.app.repo.UserRepo;

import java.util.Optional;

@Component
public class SignInFormValidator implements Validator {

    private UserRepo repo;

    public SignInFormValidator(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SignInForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignInForm form = ((SignInForm) o);
        Optional<AppUser> appUser = repo.getOneByLogin(form.getLogin());
        
        if (!appUser.isPresent()) {
            errors.reject("bad.sign_in", "Неверный логин или пароль");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Введите логин");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Введите пароль");
    }
}
