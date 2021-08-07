package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

import wecancatchit.werehooked.Repositories.TackleShopRepository;
import wecancatchit.werehooked.models.TackleShop;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class TackleShopController {

    @Resource
    private TackleShopRepository tackleShopRepo;

    @RequestMapping("/tackleshop/{name}")
    public String displaySingleTackleShop(@PathVariable String name, Model model) {
        Optional<TackleShop> retrievedTackleShop = tackleShopRepo.findByName(name);
        model.addAttribute("tackleShop", retrievedTackleShop.get());
        return "tackleShopView";
    }
}









