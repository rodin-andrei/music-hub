package hub.music.feature.track;

import hub.music.feature.author.Author;
import hub.music.feature.author.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class TrackServiceTests {

    @Autowired
    TrackService trackService;

    @Autowired
    AuthorService authorService;

    @BeforeEach
    void beforeEach() {
        trackService.clear();
    }

    @Test
    void createNewTrackAndSaveTest() {
        Track expectedTrack = trackService.save(Track.builder()
                .title("Название")
                .time(256)
                .genre("jazz")
                .build());

        Track actualTrack = trackService.getById(expectedTrack.getId());
        Assertions.assertEquals(expectedTrack, actualTrack);

    }

    @Test
    void testGetTrackByID() {
        Track expectedTrack = trackService.save(Track.builder()
                .title("Son")
                .time(184)
                .genre("classic")
                .build());

        Track actualTrack = trackService.getById(1);
        Assertions.assertEquals(expectedTrack, actualTrack);
    }

    @Test
    void testCorrectDeleteById() {
        Track track1 = trackService.save(Track.builder()
                .title("Название1")
                .time(256)
                .genre("jazz")
                .build());
        Track track2 = trackService.save(Track.builder()
                .title("Название")
                .time(342)
                .genre("rock")
                .build());
        trackService.deleteById(track1.getId());

        List<Track> tracks = trackService.queryAll();
        Assertions.assertEquals(1, tracks.size());
        Assertions.assertEquals(track2, tracks.get(0));
    }

    @Test
    void testCorrectUpdateTrackAuthor() {
        Author author1 = authorService.save(Author.builder()
                .firstname("firstNameStart")
                .lastname("lastNameStart")
                .pseudonym("pseudonymStart")
                .build());

        Track track1 = trackService.save(Track.builder()
                .title("Название1")
                .time(256)
                .genre("jazz")
                .build());

        trackService.addNewAuthorToTrack(author1.getId(), track1.getId());

        Assertions.assertEquals(
                Set.of(author1),
                trackService.getById(track1.getId()).getAuthor());

    }

}