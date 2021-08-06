package wecancatchit.werehooked.Repositories;

import org.springframework.data.repository.CrudRepository;
import wecancatchit.werehooked.models.Fish;

import java.util.Optional;

public interface FishRepository extends CrudRepository<Fish, Long> {
    @Override
    Optional<Fish> findById(Long aLong);
    Fish findFishByName (String name);

    //Fish findFishByWater(String Water)
    //Fish findFishByBait (String Bait)

}
