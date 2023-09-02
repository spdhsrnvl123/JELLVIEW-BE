package com.folder.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
    private Integer RIdx;
    private String Title;
    private String Content; 
    private Integer JIdx;
    private Integer Star;
    private Date Created_at;
}
