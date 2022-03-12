package hub.music.feature.track;

import hub.music.feature.author.Author;
import hub.music.feature.author.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Collections;


@SpringBootTest
public class TrackIntegrationTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private TrackService trackService;

    @Test
    void testCascadeRemoveTracks() {
        Author author = getAuthor();

        Author byId1 = authorService.getById(author.getId());
        System.out.println(byId1.getTracks().size());

    }

    @Transactional
    Author getAuthor() {
        Author author = authorService.save(Author.builder()
                .firstname("Grigoryi")
                .lastname("Leps")
                .pseudonym(null)
                .build());
        Track track = trackService.save(Track.builder()
                .author(Collections.singleton(author))
                .time(10)
                .genre("Popsa")
                .build());
        Track trackFromDB = trackService.getById(track.getId());
        trackFromDB.getAuthor()
                .forEach(author1 -> System.out.println(author1.getFirstname()));
        return author;
    }


}
