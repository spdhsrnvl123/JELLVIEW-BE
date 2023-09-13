package com.folder.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.KakaoInfo;
import com.folder.app.mapper.KakaoMapper;

@Repository
public class KakaoDAO {
    @Autowired KakaoMapper kMapper;

    public Object save(KakaoInfo kakaoInfo) {
        return kMapper.save(kakaoInfo);
    }
    
    public int findInfo(KakaoInfo kakaoInfo) {
            // int rowCount = kMapper.findInfo(kakaoInfo);
            // System.out.println(rowCount);
        return kMapper.findInfo(kakaoInfo);
    }
}
