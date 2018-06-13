package ru.kpfu.itis.app.model.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.itis.app.model.enums.AccessRight;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String imageUrl;

    private String name;

    private String password;

    private String uid;

    private String cookie;

    @Column(name = "access_right")
    @Enumerated(EnumType.STRING)
    private AccessRight role;
}
