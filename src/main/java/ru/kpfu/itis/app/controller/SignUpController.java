package ru.kpfu.itis.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.app.forms.SignUpForm;
import ru.kpfu.itis.app.service.AjaxService;
import ru.kpfu.itis.app.service.AppUserService;
import ru.kpfu.itis.app.validators.SignUpFormValidator;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private AppUserService service;
    private AjaxService ajaxService;
    private SignUpFormValidator validator;

    public SignUpController(AppUserService service, AjaxService ajaxService, SignUpFormValidator validator) {
        this.service = service;
        this.ajaxService = ajaxService;
        this.validator = validator;
    }

    @InitBinder("signUpForm")
    public void initSignUpFormValidator(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @PostMapping("/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult errors,
                         RedirectAttributes attr) {
        if (errors.hasErrors()) {
            attr.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            attr.addFlashAttribute("signUpForm", form);
            return "redirect:/signUp";
        }
        service.signUp(form);
        return "redirect:/signIn";

    }

    @GetMapping("/signUp")
    public String getSignUpPage(@ModelAttribute("signUpForm") SignUpForm form, Model model) {
        if (form == null) {
            form = new SignUpForm();
        }
        model.addAttribute("signUpForm", form);

        return "signUp";
    }
}
