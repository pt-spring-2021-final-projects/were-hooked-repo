package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    String landingPage() {
        return "landing";
    }
    
    @RequestMapping("/rules")
    String rules() {
        return "rules";
    }

    @RequestMapping("/home")
    String home() {
        return "home";
    }
    
    @RequestMapping("/restricted")
    String restricted() {
        return "restricted";
    }
}
