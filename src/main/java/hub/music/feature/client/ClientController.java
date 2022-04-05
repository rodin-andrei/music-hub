package hub.music.feature.client;

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
                         @RequestParam String mobilePhone1)
                        {
        return clientService.save(Client.builder()
                .firstname(firstname)
                .lastname(lastname)
                .mobilePhone(mobilePhone1)
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

    @PutMapping ("/updateFirstname")
    public void updateFirstname(@RequestParam Integer id,@RequestParam String firstname) {
        clientService.updateClientFirstname(id,firstname);
    }

    @PutMapping ("/updateLastname")
    public void updateLastname(@RequestParam Integer id,@RequestParam String lastname) {
        clientService.updateClientLastname(id, lastname);
    }

    @PutMapping ("/updateMobilePhone1")
    public void updateClientMobilePhone1(@RequestParam Integer id,@RequestParam String mobilePhone1) {
        clientService.updateClientMobilePhone1(id, mobilePhone1);
    }

    @PutMapping ("/updateEmail")
    public void updateClientEmail(@RequestParam Integer id,@RequestParam String email) {
        clientService.updateClientEmail(id, email);
    }

    @PutMapping ("/updatePassword")
    public void updateClientPassword(@RequestParam Integer id,@RequestParam String password) {
        clientService.updateClientPassword(id, password);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Integer id) {
        clientService.deleteById(id);
    }
}

