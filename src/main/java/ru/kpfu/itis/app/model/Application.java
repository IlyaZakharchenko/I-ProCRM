package ru.kpfu.itis.app.model;

import lombok.*;
import ru.kpfu.itis.app.model.enums.ApplicationStatus;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;

    private String content;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "application_file",
            joinColumns = { @JoinColumn(name = "application_id") },
            inverseJoinColumns = { @JoinColumn(name = "file_id") }
    )
    private List<File> fileList;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
}
