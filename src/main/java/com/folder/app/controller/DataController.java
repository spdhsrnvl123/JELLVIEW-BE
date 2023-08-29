package com.folder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.JellyResultDTO;
import com.folder.app.dto.ReviewDTO;
import com.folder.app.service.JellyService;
import com.folder.app.service.ReviewService;

@CrossOrigin(origins = "http://localhost:5001")
@RestController
public class DataController {
    @GetMapping("/")
    public String home(){
        return "성공성공!!!!!!";
    }

    @GetMapping("/api")
    public String api(){
        return "Api Data 준비 중...";
    }
    
    @Autowired JellyService jService;

    @GetMapping("/jellies")
    public JellyResultDTO jellyFindAll(){
        return jService.jellyFindAll();
    }

    @Autowired ReviewService rService;

    @PostMapping("/save")
    public Object save(@RequestBody ReviewDTO rDto){
        System.out.println(rDto);
        return rService.save(rDto);
    }
}
