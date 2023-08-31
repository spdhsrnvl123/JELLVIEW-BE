package com.folder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    
    //카카오인증 @ResponseBody
    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code){

        //POST방식으로 key=value 데이터를 요청(카카오쪽으로)
        //Retrofit2
        //OkHttp
        //RestTemplate

        RestTemplate rt = new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpBody 오브젝트 생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id","e83ad4f76c812b501942955e9bd1f59a");
        params.add("redirect_uri", "http://localhost:8001/auth/kakao/callback");
        params.add("code",code);

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        //왜 요기에 담냐면 exchange라는 함수가 HttpEntity라는 오브젝트를 넣게 되어 있다.
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
        new HttpEntity<>(params, headers);

        //Http요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
            "https://kauth.kakao.com/oauth/token",
            HttpMethod.POST,
            kakaoTokenRequest, //HttpEntity오브젝트
            String.class
        );

        return response.getBody();
    }
}
