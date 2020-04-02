package com.seven.forum.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    private Integer code;
    private String message;
    private T data;

}
