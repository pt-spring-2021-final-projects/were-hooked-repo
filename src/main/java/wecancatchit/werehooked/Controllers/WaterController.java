package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wecancatchit.werehooked.Repositories.FishRepository;
import wecancatchit.werehooked.Repositories.WaterRepository;
import wecancatchit.werehooked.models.Fish;
import wecancatchit.werehooked.models.Water;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@Controller
public class WaterController {

    @Resource
    private WaterRepository waterRepo;

    @Resource
    private FishRepository fishRepo;

    @RequestMapping("/waters")
    public String displayWaters(Model model) {
        model.addAttribute("water", waterRepo.findAll());
        return "watersView";
    }

    @RequestMapping("/waters/{name}")
    public String displaySingleWater(@PathVariable String name, Model model) {
        Optional<Water> retrievedWater = waterRepo.findByName(name);
        model.addAttribute("water", retrievedWater.get());
        return "waterView";
    }
}