package com.folder.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.ReviewDAO;
import com.folder.app.dto.ReviewDTO;


@Service
public class ReviewService {
    @Autowired ReviewDAO uDao;

    //후기 저장
    public String save(ReviewDTO rDto){
        uDao.save(rDto);
        return "후기가 저장되었습니다.";
    }

    //후기 조회
    public Object reviewFindAll(){
        return uDao.jellyFindAll();
    }

    //후기 삭제
    public Object delete(int id){
        uDao.delete(id);
        return "삭제되었습니다";
    }

    //후기 수정
    public String editById(ReviewDTO rDto){
        uDao.editById(rDto);
        return "후기가 수정되었습니다.";
    }

    // 후기 이메일 조회
    public Object myReviewFindAll(String email){
        return uDao.myReviewFindAll(email);
    }

    public List<ReviewDTO> pagingList(int page){
        int pageLimit = 3;
        /*
          1page => 0
          2page => 3
          3page => 6
        */
        int pagingStart = (page - 1) * pageLimit;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        // List<ReviewDTO> pagingResult = ReviewDAO.pagingList(pagingParams);
        

        return uDao.pagingList(pagingParams);
    }
}