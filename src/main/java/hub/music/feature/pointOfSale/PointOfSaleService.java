package hub.music.feature.pointOfSale;

import hub.music.feature.common.CrudService;
import org.springframework.stereotype.Service;


@Service
public class PointOfSaleService extends CrudService<PointOfSale, Integer> {

    public PointOfSaleService(PointOfSaleRepository pointOfSaleRepository) { super(pointOfSaleRepository);}

    public void updateTitle(Integer id, String title) {
        PointOfSale pointOfSaleByID = getById(id);
        pointOfSaleByID.setTitle(title);
        save(pointOfSaleByID);
    }

    public void updateLocation(Integer id, float latitude, float longitude) {
        PointOfSale pointOfSaleByID = getById(id);
        pointOfSaleByID.setLatitude(latitude);
        pointOfSaleByID.setLongitude(longitude);
        save(pointOfSaleByID);
    }

    public void updateOffsetGMT(Integer id, int offsetGMT) {
        PointOfSale pointOfSaleByID = getById(id);
        pointOfSaleByID.setOffsetGMT(offsetGMT);
        save(pointOfSaleByID);
    }


}

