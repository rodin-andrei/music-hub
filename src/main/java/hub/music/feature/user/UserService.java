package hub.music.feature.user;

import hub.music.feature.common.CrudService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User, Integer> {
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    public void updateUserPosition(Integer id, String position) {
        User userServiceById = getById(id);
        userServiceById.setPosition(position);
        save(userServiceById);
    }

    public void updateUserEmail(Integer id, String eMail) {
        User userServiceById = getById(id);
        userServiceById.setUserEmail(eMail);
        save(userServiceById);
    }

    public void updateUserPassword(Integer id, String password) {
        User userServiceById = getById(id);
        userServiceById.setUserPassword(password);
        save(userServiceById);
    }
}
