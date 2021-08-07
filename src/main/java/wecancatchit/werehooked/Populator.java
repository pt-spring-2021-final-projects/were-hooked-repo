package wecancatchit.werehooked;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wecancatchit.werehooked.Repositories.BaitRepository;
import wecancatchit.werehooked.Repositories.FishRepository;
import wecancatchit.werehooked.Repositories.TackleShopRepository;
import wecancatchit.werehooked.Repositories.WaterRepository;
import wecancatchit.werehooked.models.Bait;
import wecancatchit.werehooked.models.Fish;
import wecancatchit.werehooked.models.TackleShop;
import wecancatchit.werehooked.models.Water;

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

        Bait worm = new Bait("Worm", "/images/worm.jpg");
        Bait bread = new Bait("bread","/images/bread.jpg");
        Bait minnows = new Bait("Minnows", "/images/minnow.jpg");
        Bait blueGillBait = new Bait("BlueGill","/images/bluegillbait.jpg");
        Bait texasRig = new Bait("Texas Rig","/images/texasrig.jpg");
        Bait nedRig = new Bait("Ned Rig", "/images/nedrig.jpg");
        Bait inlineSpinner = new Bait("Inline Spinner", "/images/inlinespinner.jpg");
        Bait spinnerBait = new Bait("Spinner Bait", "/images/spinnerbait.jpg");
        Bait crankBait = new Bait("Crank Bait", "/images/crankbait.jpg");
        Bait rattleTrap = new Bait("Rattle Trap", "/images/rattletrap.jpg");
        Bait popper = new Bait("Popper", "/images/popper.jpg");
        Bait jig = new Bait("Jig", "/images/jig.jpg");
        Bait waxWorm = new Bait("Wax Worm", "/images/waxworm.jpg");
        baitRepo.save(worm);
        baitRepo.save(bread);
        baitRepo.save(minnows);
        baitRepo.save(blueGillBait);
        baitRepo.save(texasRig);
        baitRepo.save(nedRig);
        baitRepo.save(inlineSpinner);
        baitRepo.save(spinnerBait);
        baitRepo.save(crankBait);
        baitRepo.save(rattleTrap);
        baitRepo.save(popper);
        baitRepo.save(jig);
        baitRepo.save(waxWorm);

        Fish blueGill = new Fish("BlueGill","The bluegill is a species of freshwater. It is a member of the sunfish family Centrarchidae of the order Perciformes. It is native to North America and lives in streams, rivers, lakes, and ponds.","Bluegill live in the shallow waters of many lakes and ponds, along with streams, creeks, and rivers. They prefer water with many aquatic plants, and seclude themselves within or near fallen logs, water weeds or any other structure (natural or manmade) that's underwater.","/images/bluegill.jpg","Spring through fall.","3.28 pounds","Dawn & Dusk are the best times.",worm, inlineSpinner);
        Fish largeMouthBass = new Fish("Large Mouth Bass", "The largemouth bass is a carnivorous freshwater gamefish in the Centrarchidae (sunfish) family, a species of black bass native to the eastern and central United States, southeastern Canada and northern Mexico, but widely introduced elsewhere.", " Largemouth bass inhabit clear, vegetated lakes, ponds, swamps, and the backwaters of pools, creeks and rivers", "/images/largemouthbass.jpg", "Spring through fall.", "13.13 pounds","Dusk and Dawn.",worm,minnows,texasRig,nedRig,inlineSpinner,spinnerBait,crankBait,rattleTrap,popper);
        Fish smallMouthBass = new Fish("Small Mouth Bass", "The smallmouth bass is a species of freshwater fish in the sunfish family (Centrarchidae). One of the black basses, it is a popular game fish sought by anglers throughout the temperate zones of North America.", "The smallmouth bass is found in clearer water than the largemouth, especially streams, rivers, and the rocky areas and stumps and also sandy bottoms of lakes and reservoirs.", "/images/smallmouthbass.jpg","Spring through fall.","9.8 pounds","Dusk and Dawn.",worm,minnows,texasRig,nedRig,inlineSpinner);
        Fish walleye = new Fish("Walleye", "The walleye also called the yellow pike or yellow pickerel, is a freshwater perciform fish native to most of Canada and to the Northern United States.", "Walleye occur in lakes, pools, back waters and runs of medium to large rivers.", "/images/walleye.jpg", "All Year round", "16.19 pounds", "Dusk and dawn", minnows,worm,crankBait, jig );
        Fish perch = new Fish("Perch", "Perch is a common name for fish of the genus Perca, freshwater gamefish belonging to the family Percidae.","Perch are carnivorous fish most commonly found in small ponds, lakes, streams, or rivers.","/images/perch.jpg","All year round","1.72 pounds","Dusk and Dawn",worm,minnows, waxWorm);
        Fish pike = new Fish("Pike", "The northern pike is a species of carnivorous fish of the genus Esox (the pikes).","Pike are found in sluggish streams and shallow, weedy places in lakes and reservoirs, as well as in cold, clear, rocky waters.","/images/pike.jpg","All year round","22.78 pounds","late morning and early afternoon",minnows,inlineSpinner, spinnerBait,jig,popper);
        Fish muskie = new Fish("Muskie", "The muskellunge, often shortened to muskie, musky or lunge, is a species of large freshwater fish native to North America.","Muskellunge are found in oligotrophic and mesotrophic lakes and large rivers from northern Michigan, northern Wisconsin, and northern Minnesota through the Great Lakes region.","/images/muskie.jpg","All year round","55.13 pounds","Dusk and Dawn.",minnows,crankBait,spinnerBait,inlineSpinner,popper);
        Fish saugeye = new Fish("Saugeye", "Saugeye are a hybrid produced by the Ohio division of wildlife and stocked annually into many of Ohio's reservoirs for the purpose of creating sport fisheries.", "Saugeye tend to congregate near the bottom on sand bars or near ledges and drop-offs.","/images/saugeye.jpg","All year Round","14.04 pounds","Dawn & Dusk.",minnows,jig,spinnerBait,inlineSpinner);
        fishRepo.save(blueGill);
        fishRepo.save(largeMouthBass);
        fishRepo.save(smallMouthBass);
        fishRepo.save(walleye);
        fishRepo.save(perch);
        fishRepo.save(pike);
        fishRepo.save(muskie);
        fishRepo.save(saugeye);

        Water lakeErie = new Water("Lake Erie", "Lake Erie is the fourth-largest lake (by surface area) of the five Great Lakes in North America and the eleventh-largest globally.", 9910.00, 62.00,"42.0669° N, 81.3399° W", "/images/lakeerie.jpg","Great Lake",true,erieOutfitters,blueGill,largeMouthBass,smallMouthBass,walleye,perch,pike,muskie,saugeye);
        Water caesarsCreek = new Water("Caesars Creek","Caesar Creek State Park is a public recreation area located in southwestern Ohio, five miles east of Waynesville, in Warren, Clinton, and Greene counties.",4.42,25.00,"39°29′07″N 84°03′55″W","/images/caesarcreek.jpg","Reservoir",true,spillWayPartySupply,blueGill,largeMouthBass,smallMouthBass,walleye,perch,pike,muskie,saugeye);
        Water alumCreek = new Water("Alum Creek","Alum Creek Lake is a man-made reservoir located in Delaware County, Ohio, United States.",5.00,25.00,"40.185718°N 82.966636°W","/images/alumcreek.jpg","Impound",true,oldDutchmanBaitAndTackle,blueGill,largeMouthBass,smallMouthBass,perch,pike,muskie,saugeye);
        Water indianLake = new Water("Indian Lake","Indian Lake (formerly Lewistown Reservoir) is a reservoir in Logan County, western Ohio, in the United States.",7.97,10.00,"40°28′03″N 83°52′31″W","/images/indianlake.jpg","Reservoir",true,indianLakeOutfitters,blueGill,largeMouthBass,smallMouthBass,perch,walleye,saugeye,pike);
        waterRepo.save(lakeErie);
        waterRepo.save(caesarsCreek);
        waterRepo.save(alumCreek);
        waterRepo.save(indianLake);

    }

}