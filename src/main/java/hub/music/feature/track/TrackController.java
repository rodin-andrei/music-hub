package hub.music.feature.track;

import hub.music.feature.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping("/{id}")
    public Track get(@PathVariable Integer id) {
        return trackService.getById(id);
    }

    @GetMapping("/")
    public List<Track> get() {
        return trackService.queryAll();
    }

    @PutMapping("/create")
    public Track create(@RequestParam String genre,
                        @RequestParam Integer time,
                        @RequestParam String title,
                        @RequestParam Integer authorId) {
        Track track = trackService.save(Track.builder()
                .time(time)
                .genre(genre)
                .title(title)
                .build());
        trackService.addNewAuthorToTrack(authorId, track.getId());

        return track;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        trackService.deleteById(id);
    }

    @PostMapping("/updateTrackAuthors")
    public void updateTrackAuthors(@RequestParam Integer trackId, @RequestParam Integer authorId) {
        trackService.addNewAuthorToTrack(authorId, trackId);
    }
}
