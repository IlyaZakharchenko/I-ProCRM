package ru.kpfu.itis.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.app.forms.FacebookSignForm;

@Component
public class FacebookSignFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return FacebookSignForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.login", "Ошибка email Facebook");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Ошибка пароля Facebook");
    }
}
