package org.kdd9512.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.kdd9512.domain.BoardVO;
import org.kdd9512.domain.Criteria;
import org.kdd9512.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private final BoardService service;

//    @GetMapping("/list")
//    public void list(Model model) {
//        log.info("list==================================");
//
//        model.addAttribute("list", service.getList());
//    }

    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        log.info("list =============[ " + cri +  " ]================");

        model.addAttribute("list", service.getList(cri));
    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes attributes) {

        log.info(("register : [ " + board + " ]"));

        service.register(board);

        attributes.addFlashAttribute("result", board.getBno());

        return "redirect:/board/list";

    }

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno") Long bno, Model model) {

        log.info("================================/get or /modify========================================");
        model.addAttribute("board", service.get(bno));

    }

    // 글을 수정 / 삭제하기 위해서는 뭔가 양식을 보내야 하므로 PostMapping 이 필요.
    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes attributes) {
        log.info("this number will be modified : [ " + board + " ]");

        if (service.modify(board)) {
            attributes.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/remove") // 작업 후 redirect 해야하므로 RedirectAttributes
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes attributes) {
        log.info("this number will be removed : [ " + bno + " ]");

        if (service.remove(bno)) {
            attributes.addFlashAttribute("result", "success");
        } else {
            log.info("non exist number....");
            attributes.addFlashAttribute("result", "fail");
        }

        return "redirect:/board/list";
    }

}
