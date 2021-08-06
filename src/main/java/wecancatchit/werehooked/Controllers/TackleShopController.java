package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wecancatchit.werehooked.Repositories.TackleShopRepository;
import wecancatchit.werehooked.models.TackleShop;

import javax.annotation.Resource;

@Controller

public class TackleShopController {
    @Resource
    private TackleShopRepository tackleShopRepo;

    @GetMapping("/tackleshop/{name}")
    public String displaySingleTackleShop(@PathVariable String name, Model model) {
        TackleShop retrievedTackleShop = tackleShopRepo.findByName(name);
        model.addAttribute("tackle shop", retrievedTackleShop);
        retrievedTackleShop.getTackleShopHours();
        // retrievedTackleShop.getTackleShopImage();
        retrievedTackleShop.getName();
        retrievedTackleShop.getTackleShopAddress();
        return "tackleShopView";
    }
}







