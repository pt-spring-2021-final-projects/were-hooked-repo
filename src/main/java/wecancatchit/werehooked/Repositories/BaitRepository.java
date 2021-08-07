package wecancatchit.werehooked.Repositories;

import org.springframework.data.repository.CrudRepository;
import wecancatchit.werehooked.models.Bait;

import java.util.Optional;

public interface BaitRepository extends CrudRepository<Bait, Long> {
    @Override
    Optional<Bait> findById(Long aLong);

    Bait findByName(String name);
  

}

