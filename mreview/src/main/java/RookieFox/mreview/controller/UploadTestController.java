package RookieFox.mreview.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.GeneratedValue;

@Controller
public class UploadTestController {

    @GetMapping("/uploadEx")
    public void uploadEx() {

    }
}
