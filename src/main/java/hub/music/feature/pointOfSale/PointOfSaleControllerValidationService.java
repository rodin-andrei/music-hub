package hub.music.feature.pointOfSale;

import hub.music.feature.client.Client;
import hub.music.feature.client.Roles;
import org.springframework.stereotype.Service;

@Service
public class PointOfSaleControllerValidationService {

    public void validationPointOfSale(PointOfSale pointOfSale, Client client) {

        Integer clientIdOfPointOfSale = pointOfSale.getClient().getId();
        Integer clientIdForValidation = client.getId();
        if (!clientIdOfPointOfSale.equals(clientIdForValidation) || !client.getRole().equals(Roles.ADMIN)) {
            throw new InsufficientPrivilegesException("insufficientPrivileges");
        }
    }
}