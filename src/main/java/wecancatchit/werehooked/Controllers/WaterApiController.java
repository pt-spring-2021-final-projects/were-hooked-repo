package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wecancatchit.werehooked.Repositories.FishRepository;
import wecancatchit.werehooked.Repositories.WaterRepository;
import wecancatchit.werehooked.models.Fish;
import wecancatchit.werehooked.models.Water;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
public class WaterApiController {

    @Resource
    private WaterRepository waterRepo;

    @Resource
    private FishRepository fishRepo;

    @RequestMapping("/api/waters")
    public Collection<Water> displayWaters() {
        // model.addAttribute("water", waterRepo.findAll());
        return (Collection<Water>) waterRepo.findAll();
    }

    // @RequestMapping("/waters/{name}")
    // public String displaySingleWater(@PathVariable String name, Model model) {
    //     Optional<Water> retrievedWater = waterRepo.findByName(name);
    //     model.addAttribute("water", retrievedWater.get());
    //     return "waterView";
    // }
}