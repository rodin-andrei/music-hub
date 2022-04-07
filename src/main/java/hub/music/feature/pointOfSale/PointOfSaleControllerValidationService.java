package hub.music.feature.pointOfSale;

import hub.music.feature.client.Client;

public class PointOfSaleControllerValidationService {

    public void validationPointOfSale(PointOfSale pointOfSale, Client client) {

        Integer clientIdOfPointOfSale = pointOfSale.getClient().getId();
        Integer clientIdForValidation = client.getId();
        if (!clientIdOfPointOfSale.equals(clientIdForValidation)) {
            throw new InsufficientPrivilegesException("insufficientPrivileges");
        }
    }
}