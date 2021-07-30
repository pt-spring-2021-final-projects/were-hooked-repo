package wecancatchit.werehooked.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
   @RequestMapping("/")
    String landing() {
        return "landing";
    }
    
//    @GetMapping("/hello")
//     String helloUser(@AuthenticationPrincipal OidcUser user) {
//         return "Hello " + user.getAttributes().get("email");
//     }
}
