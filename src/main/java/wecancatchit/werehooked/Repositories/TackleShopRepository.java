package wecancatchit.werehooked.Repositories;

import org.springframework.data.repository.CrudRepository;
import wecancatchit.werehooked.models.TackleShop;


import java.util.Optional;

public interface TackleShopRepository extends CrudRepository<TackleShop, Long> {
    @Override
    Optional<TackleShop> findById(Long id);

    TackleShop findByName(String name);


}