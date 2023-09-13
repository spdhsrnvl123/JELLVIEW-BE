package com.folder.app.mapper;

import java.util.List;
import java.util.Map;

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
    @Insert("insert into jelly_review (Title, Content, JIdx, Star, Email) value (#{Title},#{Content},#{JIdx},#{Star},#{Email})")
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

    //이메일로 조회
    @Select("select * from jelly_review where Email=#{email}")
    public List<ReviewDTO> myReviewFindAll(String email);

    // 페이징
    @Select("select * from jelly_review order by ridx desc limit #{start}, ${limit}")
    public List<ReviewDTO> pagingList(Map<String, Integer> pagingParams);


}
