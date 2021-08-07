package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wecancatchit.werehooked.Repositories.BaitRepository;
import wecancatchit.werehooked.models.Bait;

import javax.annotation.Resource;
import java.util.Optional;

@Controller

public class BaitController {
    @Resource
    private BaitRepository baitRepo;

//    @GetMapping("/bait/{name}")
//    public String displaySingleBait(@PathVariable String name, Model model) {
//        Bait retrievedBait = baitRepo.findByName(name);
//        model.addAttribute("bait", retrievedBait);
//        // retrievedBait.getName();   whats this doing?
//
//
//        return "baitView";
//    }

    @RequestMapping("/bait/{name}")
    public String displaySingleBait(@PathVariable String name, Model model) {
        Optional<Bait> retrievedBait = baitRepo.findByName(name);
        model.addAttribute("bait",retrievedBait.get());
        return "baitView";
    }
}