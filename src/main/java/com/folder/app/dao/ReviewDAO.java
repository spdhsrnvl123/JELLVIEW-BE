package com.folder.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.JellyDTO;
import com.folder.app.dto.KakaoInfo;
import com.folder.app.dto.ReviewDTO;
import com.folder.app.mapper.ReviewMapper;

@Repository
public class ReviewDAO {
    @Autowired
    ReviewMapper rMapper;

    public Object save(ReviewDTO rDto) {
        System.out.println(rDto);
        return rMapper.save(rDto);
    }

    public List<ReviewDTO> jellyFindAll() {
        return rMapper.reviewFindAll();
    }

    public int delete(int id) {
        return rMapper.delete(id);
    }

    public Object editById(ReviewDTO rDto) {
        System.out.println(rDto);
        return rMapper.editById(rDto);
    }

    public List<ReviewDTO> myReviewFindAll(String email){
        // System.out.println(email);
        return rMapper.myReviewFindAll(email);
        // return null;
    }

    public List<ReviewDTO> pagingList(Map<String, Integer> pagingParams){
        System.out.println(pagingParams);
        return rMapper.pagingList(pagingParams);
        // return null;
    }
}
