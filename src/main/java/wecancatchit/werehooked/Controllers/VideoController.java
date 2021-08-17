package wecancatchit.werehooked.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoController {
    
    @RequestMapping("/video")
    String rules() {
        return "video";
    }
}
