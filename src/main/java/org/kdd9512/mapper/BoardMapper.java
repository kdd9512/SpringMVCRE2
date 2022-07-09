package org.kdd9512.mapper;

import org.apache.ibatis.annotations.Select;
import org.kdd9512.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    // resources 의 xml 파일로 대체하였으므로 주석처리.
    // @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

}
