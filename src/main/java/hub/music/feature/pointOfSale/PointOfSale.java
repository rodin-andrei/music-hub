package hub.music.feature.pointOfSale;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointOfSale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private float latitude;

    private float longitude;

    private int offsetGMT;

}
