package hub.music.feature.author;

import hub.music.feature.common.CrudService;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends CrudService<Author, Integer> {
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }

    public void updateAuthorPseudonym(Integer id, String pseudonym){
        Author authorByID = getById(id);
        authorByID.setPseudonym(pseudonym);
        save(authorByID);
    }

    public void updateAuthorFirstname(Integer id, String firstname){
        Author authorByID = getById(id);
        authorByID.setFirstname(firstname);
        save(authorByID);
    }

    public void updateAuthorLastname(Integer id, String lastname){
        Author authorByID = getById(id);
        authorByID.setLastname(lastname);
        save(authorByID);
    }


}
