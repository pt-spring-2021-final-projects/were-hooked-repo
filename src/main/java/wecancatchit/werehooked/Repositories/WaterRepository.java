package wecancatchit.werehooked.Repositories;

import org.springframework.data.repository.CrudRepository;
import wecancatchit.werehooked.models.Water;

import java.util.Optional;

public interface WaterRepository extends CrudRepository<Water, Long> {
    @Override
    Optional<Water> findById(Long id);

    Water findWaterByName(String name);
}
