package at.kaindorf.intro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    Created by: Jonas Seidl
    Date: 15.10.2021
    Time: 10:26
*/
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "homepage";
    }
}
