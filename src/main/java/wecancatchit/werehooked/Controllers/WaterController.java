package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wecancatchit.werehooked.Repositories.WaterRepository;
import wecancatchit.werehooked.models.Water;
import javax.annotation.Resource;

@Controller
public class WaterController {

    @Resource
    private WaterRepository waterRepo;

    @RequestMapping("/waters")
    public String displayWaters(Model model) {
        model.addAttribute("water", waterRepo.findAll());
        return "watersView";
    }

    @GetMapping("/waters/{name}")
    public String displaySingleWater(@PathVariable String name, Model model) {
        Water retrievedWater = waterRepo.findWaterByName(name);
        model.addAttribute("water", retrievedWater);
        retrievedWater.getName();
        retrievedWater.getDescription();
        retrievedWater.getImage();
        retrievedWater.getCoordinates();
        retrievedWater.getArea();
        retrievedWater.getDepth();
        retrievedWater.getType();
        retrievedWater.isPublic();
        return "waterView";
    }
}