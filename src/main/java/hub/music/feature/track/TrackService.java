package hub.music.feature.track;

import hub.music.feature.author.Author;
import hub.music.feature.author.AuthorService;
import hub.music.feature.common.CrudService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class TrackService extends CrudService<Track, Integer> {
    private final AuthorService authorService;


    public TrackService(JpaSpecificationExecutor<Track> executor,  AuthorService authorService) {
        super(executor);
        this.authorService = authorService;
    }


    public void addNewAuthorToTrack(Integer authorId, Integer id) {
        Track track = getById(id);
        Author author = authorService.getById(authorId);
        if(track.getAuthor() == null){
            track.setAuthor(new HashSet<>());
        }
        track.getAuthor().add(author);
        save(track);
    }
}
