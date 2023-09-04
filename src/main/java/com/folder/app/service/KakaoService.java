package com.folder.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.KakaoDAO;
import com.folder.app.dto.KakaoInfo;
import com.folder.app.dto.KakaoProfile;

@Service
public class KakaoService {

    @Autowired KakaoDAO kakaoDAO;

    public KakaoInfo save(KakaoInfo kakaoInfo){
        System.out.println(kakaoInfo);

        kakaoDAO.save(kakaoInfo);
        return null;
    }
}
