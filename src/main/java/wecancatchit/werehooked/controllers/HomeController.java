package wecancatchit.werehooked.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    String landingPage() {
        return "landing";
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
