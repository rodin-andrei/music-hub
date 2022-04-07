package hub.music.feature.pointOfSale;

import hub.music.feature.client.Client;
import hub.music.feature.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pointOfSale")
@RequiredArgsConstructor
public class PointOfSaleController {

    private final PointOfSaleService pointOfSaleService;
    private final ClientService clientService;

    @PutMapping("/create")
    public PointOfSale create(@RequestParam String title,
                              @RequestParam float latitude,
                              @RequestParam float longitude,
                              @RequestParam int offSet,
                              @RequestParam Integer clientId) {

        Client addClient = clientService.getById(clientId);
        return pointOfSaleService.save(PointOfSale.builder()
                .title(title)
                .latitude(latitude)
                .longitude(longitude)
                .offsetGMT(offSet)
                .client(addClient)
                .build());

    }

    @GetMapping("/")
    public List<PointOfSale> get() {
        return pointOfSaleService.queryAll();
    }

    @GetMapping("/{id}")
    public PointOfSale get(@PathVariable Integer id) {
        return pointOfSaleService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pointOfSaleService.deleteById(id);
    }

    @PostMapping("/updateTitle")
    public void updateTitle(@RequestParam Integer id,
                            @RequestParam String title) {
        pointOfSaleService.updateTitle(id, title);
    }

    @PostMapping("/updateLocation")
    public void updateLocation(@RequestParam Integer id,
                               @RequestParam float latitude,
                               @RequestParam float longitude) {
        pointOfSaleService.updateLocation(id, latitude, longitude);
    }

    @PostMapping("/updateOffsetGMT")
    public void updateOffsetGMT(@RequestParam Integer id,
                                @RequestParam int offsetGMT) {
        pointOfSaleService.updateOffsetGMT(id, offsetGMT);
    }
}
