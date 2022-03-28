package hub.music.feature.track;

import hub.music.feature.pointOfSale.PointOfSale;
import hub.music.feature.pointOfSale.PointOfSaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PointOfSaleTests {

    @Autowired
    PointOfSaleService pointOfSaleService;

    @BeforeEach
    void beforeEach() {
        pointOfSaleService.clear();
    }

    @Test
    void testCreatePointOfSale() {

        PointOfSale expectedPointOfSale = pointOfSaleService.save(PointOfSale.builder()
                .title("MoscowSity")
                .latitude(0.2545f)
                .longitude(0.54858f)
                .offsetGMT(-3)
                .build());

        PointOfSale actualPointOfSale = pointOfSaleService.getById(1);
        Assertions.assertEquals(expectedPointOfSale, actualPointOfSale);
    }

    @Test
    void testUpdatePointOfSale() {

        PointOfSale pointOfSale1 = pointOfSaleService.save(PointOfSale.builder()
                .title("Moscow-Sity")
                .latitude(0.2545f)
                .longitude(0.54858f)
                .offsetGMT(-3)
                .build());

        PointOfSale pointOfSale2 = pointOfSaleService.save(PointOfSale.builder()
                .title("Hamburg-Sity")
                .latitude(0.34855f)
                .longitude(0.35486f)
                .offsetGMT(-1)
                .build());

        PointOfSale pointOfSale3 = pointOfSaleService.save(PointOfSale.builder()
                .title("London-Sity")
                .latitude(0.34655f)
                .longitude(0.393186f)
                .offsetGMT(0)
                .build());



        pointOfSaleService.updateTitle( pointOfSale2.getId(), "Berlin-Sity");
        pointOfSaleService.updateLocation(pointOfSale2.getId(), 0.278878f, 0.56878f);
        pointOfSaleService.updateOffsetGMT(pointOfSale2.getId(), -1);

        PointOfSale expectedPointOfSale = PointOfSale.builder()
                .id(pointOfSale2.getId())
                .title("Berlin-Sity")
                .latitude(0.278878f)
                .longitude(0.56878f)
                .offsetGMT(-1)
                .build();

        PointOfSale actualPointOfSale = pointOfSaleService.getById(pointOfSale2.getId());

        Assertions.assertEquals(expectedPointOfSale, actualPointOfSale);
    }


    @Test
    void testCorrectDeletePointOfSale() {

        PointOfSale pointOfSale1 = pointOfSaleService.save(PointOfSale.builder()
                .title("Moscow-Sity")
                .latitude(0.2545f)
                .longitude(0.54858f)
                .offsetGMT(-3)
                .build());

        PointOfSale pointOfSale2 = pointOfSaleService.save(PointOfSale.builder()
                .title("Hamburg-Sity")
                .latitude(0.34855f)
                .longitude(0.35486f)
                .offsetGMT(-1)
                .build());

        PointOfSale pointOfSale3 = pointOfSaleService.save(PointOfSale.builder()
                .title("London-Sity")
                .latitude(0.34655f)
                .longitude(0.393186f)
                .offsetGMT(0)
                .build());

        pointOfSaleService.deleteById(pointOfSale2.getId());
        List expectedPointOfSaleList = List.of(pointOfSale1, pointOfSale3);

        Assertions.assertEquals(2,pointOfSaleService.queryAll().size());
        Assertions.assertEquals(expectedPointOfSaleList, pointOfSaleService.queryAll());

    }

}
