package org.kdd9512.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.kdd9512.domain.BoardVO;
import org.kdd9512.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list==================================");

        model.addAttribute("list", service.getList());
    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes attributes) {

        log.info(("register : [ " + board + " ]"));

        service.register(board);

        attributes.addFlashAttribute("result", board.getBno());

        return "redirect:/board/list";

    }

}
