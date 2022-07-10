package org.kdd9512.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.kdd9512.domain.BoardVO;
import org.kdd9512.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {

    }

    @Override
    public BoardVO get(Long bno) {
        return null;
    }

    @Override
    public boolean modify(BoardVO board) {
        return false;
    }

    @Override
    public boolean remove(Long bno) {
        return false;
    }

    @Override
    public List<BoardVO> getList() {
        return null;
    }
}
