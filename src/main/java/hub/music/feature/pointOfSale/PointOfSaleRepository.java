package hub.music.feature.pointOfSale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointOfSaleRepository extends JpaRepository<PointOfSale, Integer>, JpaSpecificationExecutor<PointOfSale> {
}
