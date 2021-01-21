package RookieFox.guestbook.controller;

import RookieFox.guestbook.dto.PageRequestDTO;
import RookieFox.guestbook.dto.PageResultDTO;
import RookieFox.guestbook.entity.Guestbook;
import RookieFox.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping({"/"})
    public String index() {

        return "/guestbook/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list...........");

        model.addAttribute("result", service.getList(pageRequestDTO));
    }
}
