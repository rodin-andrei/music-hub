package hub.music.feature.track;

import hub.music.feature.common.CrudService;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class TrackService extends CrudService<Track,Integer> {
    public TrackService(JpaSpecificationExecutor<Track> executor) {
        super(executor);
    }
}
