package RookieFox.mreview.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
@Log4j2
public class movieController {

    @GetMapping("/register")
    public void register() {

    }

    @GetMapping("/test")
    public void test() {

    }
}
