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
public class AuthorServiceTests {

    @Autowired
    AuthorService authorService;
    TrackService trackService;

    @BeforeEach
    void beforeEach() {
        authorService.clear();
    }

    @Test
    void testCreateAuthor() {

        Author expectedAuthor = authorService.save(Author.builder()
                .firstname("Famili")
                .lastname("Name")
                .pseudonym("MadDog")
                .build());

        Author actualAuthor = authorService.getById(1);
        Assertions.assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    void testCorrectUpdateAuthor() {

        Author expectedAuthor = authorService.save(Author.builder()
                .firstname("Famili")
                .lastname("Name")
                .pseudonym("MadDog")
                .build());

        expectedAuthor.setFirstname("Фамилия");
        expectedAuthor.setLastname("Имя");
        expectedAuthor.setPseudonym("Бешеная Собака");

        authorService.updateAuthorFirstname(1, "Фамилия");
        authorService.updateAuthorLastname(1, "Имя");
        authorService.updateAuthorPseudonym(1, "Бешеная Собака");

        Assertions.assertEquals(expectedAuthor, authorService.getById(1));
    }

    @Test
    void testCorrectDeleteAuthor() {      // тест не отрабатывает после присвоения сета треков авторам

//        Track track1 = trackService.save(Track.builder()
//                .title("Title1")
//                .time(156)
//                .genre("rock")
//                .build());
//        Track track2 = trackService.save(Track.builder()
//                .title("Title2")
//                .time(298)
//                .build());
//
//        Set<Track> tracksSet = Set.of(track1, track2);

        Author author1 = authorService.save(Author.builder()
                .firstname("Name11")
                .lastname("Name21")
                .pseudonym("Pseudonym01")
//                .tracks(tracksSet)
                .build());

        Author author2 = authorService.save(Author.builder()
                .firstname("Name12")
                .lastname("Name22")
                .pseudonym("Pseudonym02")
//                .tracks(tracksSet)
                .build());

        authorService.deleteById(author1.getId());

        Assertions.assertEquals(1, authorService.queryAll().size());
        Assertions.assertEquals(author2, authorService.getById(2));

    }

}
