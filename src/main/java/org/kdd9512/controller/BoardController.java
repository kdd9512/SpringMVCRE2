package org.kdd9512.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.kdd9512.domain.BoardVO;
import org.kdd9512.domain.Criteria;
import org.kdd9512.domain.PageDTO;
import org.kdd9512.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
//        model.addAttribute("pageMaker", new PageDTO(cri, 123)); 임시로 페이지 수 설정.

        int total = service.getTotal(cri); // 총 페이지수를 구한다.
        log.info("Total: " + total);

        model.addAttribute("pageMaker", new PageDTO(cri, total));
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
    public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri,
                    Model model) {
        log.info("================================/get or /modify========================================");
        model.addAttribute("board", service.get(bno));

    }

    // 글을 수정 / 삭제하기 위해서는 뭔가 양식을 보내야 하므로 PostMapping 이 필요.
    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes attributes,
                         Criteria cri) {
        // 더 이상 ModelAttribute 에 담아 param 을 전달할 필요가 없다. 해당 기능은 getListLink(); 가 대신함.
//                         @ModelAttribute("cri") Criteria cri) {
        log.info("modified : [ " + board + " ]");

        if (service.modify(board)) {
            attributes.addFlashAttribute("result", "success");
        }
//          getListLink(); 가 이를 대신 수행한다.
//        attributes.addAttribute("pageNum", cri.getPageNum());
//        attributes.addAttribute("amount", cri.getAmount());

        return "redirect:/board/list" + cri.getListLink();
    }

    @PostMapping("/remove") // 작업 후 redirect 해야하므로 RedirectAttributes
    public String remove(@RequestParam("bno") Long bno,RedirectAttributes attributes,
                         Criteria cri) {
        // 더 이상 ModelAttribute 에 담아 param 을 전달할 필요가 없다. 해당 기능은 getListLink(); 가 대신함.
//                         @ModelAttribute("cri") Criteria cri) {
        log.info("removed : [ " + bno + " ]");

        if (service.remove(bno)) {
            attributes.addFlashAttribute("result", "success");
        }
        //          getListLink(); 가 이를 대신 수행한다.
//        attributes.addAttribute("pageNum", cri.getPageNum());
//        attributes.addAttribute("amount", cri.getAmount());

        return "redirect:/board/list" + cri.getListLink();
    }

}
