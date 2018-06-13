package ru.kpfu.itis.app.service;

import ru.kpfu.itis.app.forms.FacebookSignForm;
import ru.kpfu.itis.app.model.entities.AppUser;

public interface AjaxService {
    AppUser signInFacebook(FacebookSignForm form);
}
