package org.kdd9512.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Log4j2
public class MainController {

    @GetMapping("/")
    public String main() {
        log.info("==================[START]=====================");

        return "redirect:/board/list";
    }
}
