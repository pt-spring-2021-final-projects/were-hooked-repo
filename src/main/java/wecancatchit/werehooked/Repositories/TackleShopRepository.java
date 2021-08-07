package wecancatchit.werehooked.Repositories;

import org.springframework.data.repository.CrudRepository;
import wecancatchit.werehooked.models.TackleShop;

import java.util.Optional;

public interface TackleShopRepository extends CrudRepository<TackleShop, Long> {

    Optional<TackleShop> findByName(String name);

}
