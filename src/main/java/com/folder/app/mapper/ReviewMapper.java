package com.folder.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.folder.app.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {
    @Insert("insert into jelly_review (Title, Content, JIdx) value (#{Title},#{Content},#{JIdx})")
    public int save(ReviewDTO rDto);
}
