package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;

import com.folder.app.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {
    //저장
    @Insert("insert into jelly_review (Title, Content, JIdx, Star) value (#{Title},#{Content},#{JIdx},#{Star})")
    public int save(ReviewDTO rDto);

    //조회
    @Select("select * from jelly_review")
    public List<ReviewDTO> reviewFindAll();

    //삭제
    @Delete("Delete from jelly_review where ridx=#{id}")
    public int delete(int no);

    //수정
    @Update("update jelly_review set Title = #{Title}, Content = #{Content}, Star = #{Star} where RIdx = #{RIdx}")
    public int editById(ReviewDTO rDto);
}
