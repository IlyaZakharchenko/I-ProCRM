package ru.kpfu.itis.app.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebookSignForm {
    private String email;
    private String displayName;
    private String photoUrl;
    private String uid;
}
