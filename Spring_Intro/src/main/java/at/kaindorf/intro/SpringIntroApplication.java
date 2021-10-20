package at.kaindorf.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroApplication.class, args);
    }


    @GetMapping(path = "/")
    public String hello(){
        return "lol";
    }
}
