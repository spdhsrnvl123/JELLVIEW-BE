package com.folder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.JellyResultDTO;
import com.folder.app.dto.ReviewDTO;
import com.folder.app.service.JellyService;
import com.folder.app.service.ReviewService;

@CrossOrigin(origins = "http://localhost:5001")
@RestController
public class DataController {
    
    @Autowired JellyService jService;

    //젤리정보 가져오기
    @GetMapping("/jellies")
    public JellyResultDTO jellyFindAll(){
        return jService.jellyFindAll();
    }

    @Autowired ReviewService rService;

    //후기저장
    @PostMapping("/save")
    public Object save(@RequestBody ReviewDTO rDto){
        // System.out.println(rDto);
        return rService.save(rDto);
    }

    //후기조회
    @GetMapping("/review")
    public Object reviewFindAll(){
        return rService.reviewFindAll();
    }

    //후기삭제
    @DeleteMapping("/delete")
    public Object delete(@RequestParam("id") int id){
        System.out.println(id);
        return rService.delete(id);
    }
}
