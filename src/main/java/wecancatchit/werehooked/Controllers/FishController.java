package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wecancatchit.werehooked.Repositories.FishRepository;
import wecancatchit.werehooked.models.Fish;

import javax.annotation.Resource;

@Controller

public class FishController {
    @Resource
    private FishRepository fishRepo;

    @GetMapping("/fish/{name}")
    public String displaySingleFish(@PathVariable String name, Model model) {
        Fish retrievedFish = fishRepo.findFishByName(name);
        model.addAttribute("fish", retrievedFish);
        retrievedFish.getDescription();
        retrievedFish.getHabitat();
        retrievedFish.getImage();
        retrievedFish.getSeason();
        retrievedFish.getCurrentRecord();
        retrievedFish.getBestTimeOfDay();

        return "fishView";
    }
}