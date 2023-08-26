package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.JellyDTO;
import com.folder.app.mapper.JellyMapper;

@Repository
public class JellyDAO {
    @Autowired JellyMapper jMapper;

    public List<JellyDTO> jellyFindAll(){
        return jMapper.jellyFindAll();
    }
}
