package ru.kpfu.itis.app.model;

import lombok.*;
import ru.kpfu.itis.app.model.enums.AccessRight;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String cookie;

    @Column(name = "access_right")
    @Enumerated(EnumType.STRING)
    private AccessRight accessRight;
}
