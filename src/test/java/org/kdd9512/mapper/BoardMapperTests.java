package org.kdd9512.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kdd9512.domain.BoardVO;
import org.kdd9512.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList() {

        mapper.getList().forEach(log::info);

    }

    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();

        board.setTitle("새글");
        board.setContent("새 내용");
        board.setWriter("늅늅늅");

        mapper.insert(board);
        log.info(board);
    }

    @Test
    public void testInsertSelectKey() {
        BoardVO board = new BoardVO();

        board.setTitle("새글 select key");
        board.setContent("새 내용 select key");
        board.setWriter("늅늅늅");

        mapper.insertSelectKey(board);
        log.info(board);

    }

    @Test
    public void testRead() {
        BoardVO board = mapper.read(5L);

        log.info(board);

    }

    @Test
    public void testDelete() {
        log.info(("DELETE CNT : " + mapper.delete(11L)));
    }

    @Test
    public void testUpdate() {

        BoardVO board = new BoardVO();

        board.setBno(5L);
        board.setTitle("수정제목");
        board.setContent("수정내용");
        board.setWriter("수정된작가");

        int cnt = mapper.update(board);
        log.info("UPDATE CNT : " + cnt);

    }

}
