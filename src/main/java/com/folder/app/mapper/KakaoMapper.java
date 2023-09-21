package com.folder.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.folder.app.dto.KakaoInfo;

@Mapper
public interface KakaoMapper {
    //삽입
    @Insert("insert into jelly_user (Email, Nickname, Profile_img) value (#{email},#{nickname},#{profile_img})")
    public int save(KakaoInfo kakaoInfo);

    //조회
    @Select("select COUNT(Email) from jelly_user where Email = #{email}")
    public int findInfo(KakaoInfo kakaoInfo);
}
