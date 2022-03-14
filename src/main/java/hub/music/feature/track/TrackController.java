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

    @GetMapping("/create")
    public Track create(@RequestParam String genre, @RequestParam Integer time) {
        return trackService.save(Track.builder()
                .time(time)
                .genre(genre)
                .build());
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable Integer id, Author author) {
        trackService.updateTrackAuthors(id, author);
    }
}
