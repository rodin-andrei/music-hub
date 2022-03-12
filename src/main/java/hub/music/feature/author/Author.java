package hub.music.feature.author;

import hub.music.feature.track.Track;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(mappedBy = "author",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Track> tracks;

    private String firstname;

    private String lastname;

    private String pseudonym;
}
