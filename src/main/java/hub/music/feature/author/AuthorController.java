package hub.music.feature.author;


import hub.music.feature.track.Track;
import hub.music.feature.track.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/")
    public List<Author> get() {
        return authorService.queryAll();
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Integer id) {
        return authorService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Integer id) {
         authorService.deleteById(id);
    }

    @PutMapping("/create")
    public Author create(@RequestParam String firstname, @RequestParam String lastname,
                         @RequestParam String psevdonym) {
        return authorService.save(Author.builder()
                .firstname(firstname)
                .lastname(lastname)
                .pseudonym(psevdonym)
                .build());
    }


   @PutMapping ("/updateFirstname")
   public void updateFirstname(@RequestParam Integer id,@RequestParam String firstname) {
        authorService.updateAuthorFirstname(id, firstname);
   }


   @PutMapping ("/updateLastname")
   public void updateLastname(@RequestParam Integer id,@RequestParam String lastname) {
        authorService.updateAuthorLastname(id, lastname);
    }

    @PutMapping ("/updatePseudonym")
    public void updatePseudonym(@RequestParam Integer id,@RequestParam String pseudonym) {
        authorService.updateAuthorPseudonym(id, pseudonym);
    }

}





