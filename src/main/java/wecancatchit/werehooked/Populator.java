package wecancatchit.werehooked;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wecancatchit.werehooked.models.Bait;
import wecancatchit.werehooked.models.TackleShop;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private BaitRepository baitRepo;

    @Resource
    private FishRepository fishRepo;

    @Resource
    private TackleShopRepository tackleShopRepo;

    @Resource
    private WaterRepository waterRepo;

    @Override
    public void run(String... args) throws Exception {

        TackleShop erieOutfitters = new TackleShop("Erie Outfitters", "5404 Lake rd, Sheffield Lake, OH 44054", "7AM - 6PM");
        TackleShop spillWayPartySupply = new TackleShop("Spillway Party Supply", "7646 Oregina RD, Waynesville, OH 45068", "6AM - 9PM");
        TackleShop oldDutchmanBaitAndTackle = new TackleShop("Old DutchMan Bait & Tackle", "904 S Sunbury RD, Westerville, OH 43081","7AM - 7PM");
        TackleShop indianLakeOutfitters = new TackleShop("Indian Lake Outfitters", "115 E Lake St, Lakeview, OH 43331", "10AM - 6PM");
        tackleShopRepo.save(erieOutfitters);
        tackleShopRepo.save(spillWayPartySupply);
        tackleShopRepo.save(oldDutchmanBaitAndTackle);
        tackleShopRepo.save(indianLakeOutfitters);




    }


}
