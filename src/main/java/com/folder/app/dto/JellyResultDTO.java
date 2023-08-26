package com.folder.app.dto;

import lombok.Data;

@Data
public class JellyResultDTO {
    private Boolean state;
    private Object result;
    private String message;
}
