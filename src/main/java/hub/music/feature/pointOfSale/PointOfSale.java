package hub.music.feature.pointOfSale;

import hub.music.feature.client.Client;
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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
