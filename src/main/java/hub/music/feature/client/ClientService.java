package hub.music.feature.client;

import hub.music.feature.common.CrudService;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CrudService <Client, Integer>{
    public ClientService (ClientRepository clientRepository) {
        super(clientRepository);
    }

    public void updateClientFirstname(Integer id, String firstname){
        Client clientByID = getById(id);
        clientByID.setFirstname(firstname);
        save(clientByID);
    }

    public void updateClientLastname(Integer id, String lastname){
        Client clientByID = getById(id);
        clientByID.setFirstname(lastname);
        save(clientByID);
    }

    public void updateClientMobilePhone (Integer id,String mobilePhone){
        Client clientByID = getById(id);
        clientByID.setMobilePhone(mobilePhone);
        save(clientByID);
    }

    public void updateClientEmail (Integer id,String email){
        Client clientByID = getById(id);
        clientByID.setEmail(email);
        save(clientByID);
    }

    public void updateClientPassword (Integer id,String password){
        Client clientByID = getById(id);
        clientByID.setPassword(password);
        save(clientByID);
    }

    public void updateRole (Integer id,Roles role){
        Client clientByID = getById(id);
        clientByID.setRole(role);
        save(clientByID);
    }

}
