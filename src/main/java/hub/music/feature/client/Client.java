package hub.music.feature.client;

import hub.music.feature.pointOfSale.PointOfSale;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstname;

    private String lastname;

    private String mobilePhone;

    private String email;

    private String password;

    @OneToMany(mappedBy = "client")
    private Set<PointOfSale> pointsOfSale;

    private Roles role;

}
