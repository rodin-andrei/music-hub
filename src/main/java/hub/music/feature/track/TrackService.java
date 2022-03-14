package hub.music.feature.track;

import hub.music.feature.author.Author;
import hub.music.feature.common.CrudService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TrackService extends CrudService<Track, Integer> {

    public TrackService(JpaSpecificationExecutor<Track> executor, TrackRepository trackRepository) {
        super(executor);
    }

    public void updateTrackAuthors(Integer trackId, Author author) {
        Track track = getById(trackId);
        track.getAuthor().add(author);
        save(track);
    }
}
