package ru.kpfu.itis.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kpfu.itis.app.forms.FacebookSignForm;
import ru.kpfu.itis.app.forms.SignInForm;
import ru.kpfu.itis.app.service.AjaxService;
import ru.kpfu.itis.app.validators.FacebookSignFormValidator;

import javax.validation.Valid;

@Controller
public class FacebookSignController {

    private AjaxService ajaxService;
    private FacebookSignFormValidator validator;

    public FacebookSignController(AjaxService ajaxService, FacebookSignFormValidator validator) {
        this.ajaxService = ajaxService;
        this.validator = validator;
    }

    @InitBinder("facebookForm")
    public void initSignUpFormValidator(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @PostMapping("/signIn/facebook")
    public ResponseEntity ajaxCheck(@Valid @RequestBody FacebookSignForm form) {
        return ResponseEntity.ok(form);
    }
}
