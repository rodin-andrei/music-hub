package hub.music.feature.author;

import hub.music.feature.common.CrudService;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends CrudService<Author, Integer> {
    public AuthorService(AuthorRepository authorRepository) {
        super(authorRepository);
    }
}
