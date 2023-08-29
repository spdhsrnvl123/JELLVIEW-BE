package com.folder.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.ReviewDAO;
import com.folder.app.dto.ReviewDTO;


@Service
public class ReviewService {
    @Autowired ReviewDAO uDao;

    public Object save(ReviewDTO rDto){
        System.out.println("===");
        System.out.println(rDto);

        uDao.save(rDto);

        return rDto;
    }
}
