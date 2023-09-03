package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.JellyDTO;
import com.folder.app.dto.ReviewDTO;
import com.folder.app.mapper.ReviewMapper;

@Repository
public class ReviewDAO {
    @Autowired ReviewMapper rMapper;

    public Object save(ReviewDTO rDto){
        System.out.println(rDto);
        return rMapper.save(rDto);
    }

    public List<ReviewDTO> jellyFindAll(){
        return rMapper.reviewFindAll();
    }

    public int delete(int id){
        return rMapper.delete(id);
    }

    public Object editById(ReviewDTO rDto){
    System.out.println(rDto);
    return rMapper.editById(rDto);
    // return null;
    }

}
