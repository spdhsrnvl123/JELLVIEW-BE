package com.folder.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.ReviewDTO;
import com.folder.app.mapper.ReviewMapper;

@Repository
public class ReviewDAO {
    @Autowired ReviewMapper rMapper;

    public int save(ReviewDTO rDto){
        System.out.println(rDto);
        return rMapper.save(rDto);
    }
}
