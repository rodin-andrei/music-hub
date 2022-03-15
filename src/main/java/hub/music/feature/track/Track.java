package hub.music.feature.track;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hub.music.feature.author.Author;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "track_author",
            joinColumns = { @JoinColumn(name = "track_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<Author> author;

    private int time;

    private String genre;

}
