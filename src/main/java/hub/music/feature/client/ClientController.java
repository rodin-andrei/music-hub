package hub.music.feature.client;

import hub.music.feature.pointOfSale.PointOfSaleControllerValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PutMapping("/create")
    public Client create(@RequestParam String firstname,
                         @RequestParam String lastname,
                         @RequestParam String mobilePhone,
                         @RequestParam String email,
                         @RequestParam String password) {
        return clientService.save(Client.builder()
                .firstname(firstname)
                .lastname(lastname)
                .mobilePhone(mobilePhone)
                .email(email)
                .password(password)
                .build());
    }

    @GetMapping("/")
    public List<Client> get() {
        return clientService.queryAll();
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable Integer id) {
                return clientService.getById(id);
    }

    @PutMapping("/updateFirstname")
    public void updateFirstname(@RequestParam Integer id, @RequestParam String firstname) {

        clientService.updateClientFirstname(id, firstname);
    }

    @PutMapping("/updateLastname")
    public void updateLastname(@RequestParam Integer id, @RequestParam String lastname) {
        clientService.updateClientLastname(id, lastname);
    }

    @PutMapping("/updateMobilePhone")
    public void updateClientMobilePhone(@RequestParam Integer id, @RequestParam String mobilePhone) {
        clientService.updateClientMobilePhone(id, mobilePhone);
    }

    @PutMapping("/updateEmail")
    public void updateClientEmail(@RequestParam Integer id, @RequestParam String email) {
        clientService.updateClientEmail(id, email);
    }

    @PutMapping("/updatePassword")
    public void updateClientPassword(@RequestParam Integer id, @RequestParam String password) {
        clientService.updateClientPassword(id, password);
    }

    @PutMapping("/updateRole")
    public void updateRole(@RequestParam Integer id, @RequestParam Roles role) {
        clientService.updateRole(id, role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.deleteById(id);
    }
}

