package com.folder.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
    private Integer RIdx;
    private String Title; //후기수정 가능
    private String Content; //후기수정 가능
    private Integer JIdx;
    private Integer Star; //후기수정 가능
    private Date Created_at;
    private String Email;
}
