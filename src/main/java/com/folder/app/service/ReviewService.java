package com.folder.app.service;

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
}
