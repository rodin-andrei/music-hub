package hub.music.feature.user;

import hub.music.feature.pointOfSale.PointOfSale;
import hub.music.feature.track.Track;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String position;

    private Set<PointOfSale> userPointsOfSale;

    private String userEmail;

    private String userPassword;
}
