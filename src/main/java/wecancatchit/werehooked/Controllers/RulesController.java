package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RulesController {
    
    @RequestMapping("/rules")
    String rules() {
        return "rules";
    }
}
