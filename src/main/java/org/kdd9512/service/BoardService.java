package org.kdd9512.service;

import org.kdd9512.domain.BoardVO;
import org.kdd9512.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

//    public List<BoardVO> getList();
    public List<BoardVO> getList(Criteria cri);

}
