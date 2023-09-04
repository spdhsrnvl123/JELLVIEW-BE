package com.folder.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.KakaoInfo;
import com.folder.app.dto.KakaoProfile;
import com.folder.app.mapper.KakaoMapper;

@Repository
public class KakaoDAO {
    @Autowired KakaoMapper kMapper;

    public Object save(KakaoInfo kakaoInfo) {
        System.out.println(kakaoInfo);
        return kMapper.save(kakaoInfo);
    }
}
