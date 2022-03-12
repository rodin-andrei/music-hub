package hub.music.feature.track;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrackRepository extends JpaRepository<Track, Integer>, JpaSpecificationExecutor<Track> {
}
