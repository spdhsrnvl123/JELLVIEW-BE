package com.folder.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.folder.app.dto.KakaoInfo;


@Mapper
public interface KakaoMapper {
    @Insert("insert into jelly_user (Email, Nickname, Profile_img) value (#{email},#{nickname},#{profile_img})")
    public int save(KakaoInfo kakaoInfo);
}
