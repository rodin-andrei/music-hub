package hub.music.feature.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/hub/music/feature/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PutMapping("/create")
    public User create(@RequestParam String position,
                       @RequestParam String userEmail,
                       @RequestParam String userPassword) {
        return userService.save(User.builder()
                .position(position)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .build());
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/")
    public List<User> get() {
        return userService.queryAll();
    }

    @PostMapping("/updateUserPosition")
    public void updateUserPosition(@RequestParam Integer id,
                                   @RequestParam String position) {
        userService.updateUserPosition(id, position);
    }

    @PostMapping("/updateUserEmail")
    public void updateUserEmail(@RequestParam Integer id,
                                @RequestParam String eMail) {
        userService.updateUserEmail(id, eMail);
    }

    @PostMapping("/updateUserPassword")
    public void updateUserPassword(@RequestParam Integer id,
                                   @RequestParam String newPassword) {
        userService.updateUserPassword(id, newPassword);
    }

    @DeleteMapping("/delete")
    public void deleteUser(Integer id){
        userService.deleteById(id);
    }

}
