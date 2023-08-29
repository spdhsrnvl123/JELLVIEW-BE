package com.folder.app.dto;

import lombok.Data;

@Data
public class JellyDTO {
    private Integer jidx; //젤리번호
    private String jName; //젤리이름
    private String jDetail; //젤리상세정보
    private String jImg;
    private Double jCalorie;
    private Double jProvince;
    private Double jSaturatedFat;
    private Double jCarbohydrate;
    private Double jSugars;
    private Double jProtein;
    private Double jSalt;
}
