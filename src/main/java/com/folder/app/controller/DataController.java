package com.folder.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.folder.app.dto.JellyResultDTO;
import com.folder.app.dto.KakaoInfo;
import com.folder.app.dto.KakaoProfile;
import com.folder.app.dto.OAuthToken;
import com.folder.app.dto.ReviewDTO;
import com.folder.app.mapper.KakaoMapper;
import com.folder.app.service.JellyService;
import com.folder.app.service.KakaoService;
import com.folder.app.service.ReviewService;

import ch.qos.logback.core.model.Model;

@CrossOrigin(origins = "http://localhost:5001")
@RestController
public class DataController {

    @Autowired
    JellyService jService;

    // 젤리정보 가져오기
    @GetMapping("/jellies")
    public JellyResultDTO jellyFindAll() {
        return jService.jellyFindAll();
    }

    @Autowired
    ReviewService rService;

    // 후기저장
    @PostMapping("/save")
    public String save(@RequestBody ReviewDTO rDto) {
        System.out.println(rDto);
        return rService.save(rDto);
    }

    // 후기조회
    @GetMapping("/review")
    public Object reviewFindAll() {
        return rService.reviewFindAll();
    }

    // 후기 이메일 조회
    @GetMapping("/review/{email}")
    public Object myReviewFindAll(@PathVariable(name="email") String email){
        // System.out.println(email);
        return rService.myReviewFindAll(email);
    }

    // 후기삭제
    @DeleteMapping("/delete")
    public Object delete(@RequestParam(name = "id") int id) {
        System.out.println(id);
        return rService.delete(id);
    }

    // 후기수정
    @PostMapping("/editById")
    public String editById(@RequestBody ReviewDTO rDto) {
        System.out.println(rDto);
        return rService.editById(rDto);
    }

    //페이징 중
    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value="page", required = false, defaultValue = "1") int page){
        System.out.println("page = " + page);
        //해당 페이지에서 보여줄 글 목록
        List<ReviewDTO> pagingList = rService.pagingList(page);
        System.out.println(pagingList);
        return "출력되었습니다.";
        // return null;
    }

    @Autowired
    KakaoService kakaoService;

    // 카카오인증
    // 프론트에서 인가코드를 받아옴, 받은 인가코드로 카카오서버에서 액세스 토큰 받아와서 반환
    @GetMapping("/auth/kakao/callback")
    public String login(@RequestParam(value = "code") String code) {
        // public @ResponseBody ResponseEntity<String> kakaoCallback(String code) { //
        // ResponseBody를 붙이면 Data를 리턴해주는 컨트롤러 함수
        // POST방식으로 key=value 데이터를 요청(카카오쪽으로) ->Retrofit2, OkHttp, RestTemplate
        // HttpHeader 오브젝트 생성
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HttpBody 오브젝트 생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "e83ad4f76c812b501942955e9bd1f59a");
        params.add("redirect_uri", "http://localhost:5001/auth/kakao/callback");
        params.add("code", code);

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        // 왜 요기에 담냐면 exchange라는 함수가 HttpEntity라는 오브젝트를 넣게 되어 있다.
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        // Http요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest, // HttpEntity오브젝트
                String.class);

        System.out.println(response.getBody());
        return response.getBody();
    }

    @GetMapping("/auth/kakao/user")
    public Object userInfo(@RequestParam(value = "token") String token) {
        System.out.println(token);

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type",
        "application/x-www-form-urlencoded;charset=utf-8");

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        // 왜 요기에 담냐면 exchange라는 함수가 HttpEntity라는 오브젝트를 넣게 되어 있다.
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        // Http요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest, // HttpEntity오브젝트
                String.class);
                // ----------

    // 멤버변수에 넣어주기
    // Gson, Json Simple, ObjectMapper
     ObjectMapper objectMapper = new ObjectMapper();
     KakaoProfile kakaoProfile = null;
     try {
     kakaoProfile = objectMapper.readValue(response.getBody(),
     KakaoProfile.class);
     } catch (JsonMappingException e) {
     e.printStackTrace();
     } catch (JsonProcessingException e) {
     e.printStackTrace();
     } // OAuthToken.class response.getBody()를 넣어준다.
     
    String email = kakaoProfile.getKakao_account().getEmail();
    String nickname = kakaoProfile.getProperties().nickname;
    String profile_img = kakaoProfile.getProperties().profile_image;


    //kakaoInfo DTO에 email,nickname,profile_img 값 집어넣기
    KakaoInfo kakaoInfo = new KakaoInfo();
    System.out.println(kakaoInfo);

    kakaoInfo.setEmail(email);
    kakaoInfo.setNickname(nickname);
    kakaoInfo.setProfile_img(profile_img);

    if(kakaoService.findInfo(kakaoInfo) == 0){
        System.out.println("데이터베이스 저장된 정보가 없어요 저장하고 유저정보줄게요");
        kakaoService.save(kakaoInfo);
        return kakaoInfo;
    }else{
        System.out.println("데이터베이스 회원정보가 있네요 유저저정보 줄게요!");
        return kakaoInfo;
    }
    }
}

