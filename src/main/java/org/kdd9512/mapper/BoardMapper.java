package org.kdd9512.mapper;

import org.apache.ibatis.annotations.Select;
import org.kdd9512.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();

}
