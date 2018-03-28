package ru.kpfu.itis.app.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "Date")
    private Calendar signingDate;

    @Type(type = "Date")
    private Calendar expirationDate;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "ip_id", referencedColumnName = "id")
    private IPAddress ip;

    @OneToOne
    @JoinColumn(name = "ip_id", referencedColumnName = "id")
    private Tariff tariff;
}
