package ru.kpfu.itis.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.app.validators.SignInFormValidator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {

    private SignInFormValidator validator;
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public SignInController(SignInFormValidator validator, Facebook facebook, ConnectionRepository connectionRepository) {
        this.validator = validator;
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @InitBinder
    public void initSignInFormValidator(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @GetMapping("/signIn")
    public String login(Authentication authentication) {
        if (authentication != null || connectionRepository.findPrimaryConnection(Facebook.class) != null) {
            return "redirect:/";
        }
        return "signIn";
    }

    @GetMapping("/signIn/error")
    public String error(RedirectAttributes attr) {
        attr.addFlashAttribute("error", "Неправильный логин или пароль");
        return "redirect:/signIn";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/connect/facebook")
    public String authenticateFacebookUser() {
        connectionRepository.findPrimaryConnection(Facebook.class);
        return "redirect:/";
    }

}
