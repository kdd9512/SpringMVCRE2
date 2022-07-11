package org.kdd9512;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kdd9512.domain.BoardVO;
import org.kdd9512.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/root-context.xml")
@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = {@Autowired})
    private BoardService service;

    // 객체가 제대로 주입되고 있는지를 확인하는 test.
    // 만약 주입되고 있지 않다면 테스트는 실패하고 assertNotNull 에서 반응이 올 것.
    @Test
    public void testExist() {

        log.info(service);
        assertNotNull(service);

    }

    @Test
    public void testRegister() {

        BoardVO board = new BoardVO();
        board.setTitle("새로운 제목");
        board.setContent("새로운 내용");
        board.setWriter("새로운 작성자");

        service.register(board);

        log.info("생성된 게시물의 번호 : [ " + board.getBno() + " ]");

    }

    @Test
    public void testGetList() {

        service.getList().forEach(log::info);

    }

    @Test
    public void testGet() {

        log.info(service.get(1L));
    }

    @Test
    public void testDelete() {
        log.info(("DELETE RESULT: " + service.remove(3L)));
    }

    @Test
    public void testUpdate() {

        BoardVO board = service.get(2L);

        if (board == null) {
            return;
        }

        board.setTitle("제목 수정 완료");
        log.info("MODIFY RESULT : [ " + service.modify(board) + " ]");

    }

}
