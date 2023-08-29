package com.folder.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.JellyDAO;
import com.folder.app.dto.JellyDTO;
import com.folder.app.dto.JellyResultDTO;

@Service
public class JellyService {
    private JellyResultDTO jrDto;

    @Autowired
    JellyDAO jDao;

    public JellyResultDTO jellyFindAll(){
        jrDto = new JellyResultDTO();
        List<JellyDTO> resultList = jDao.jellyFindAll();
        if(resultList != null){
            jrDto.setState(true);
            jrDto.setResult(resultList);
            // System.out.println(resultList);
        } else {
            jrDto.setState(false);
        }
        return jrDto;
    }

}
