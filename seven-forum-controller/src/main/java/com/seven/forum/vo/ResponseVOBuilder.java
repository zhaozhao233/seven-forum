package com.seven.forum.vo;

public final class ResponseVOBuilder<T> {
    private Integer code;
    private String message;
    private T data;

    private ResponseVOBuilder() {
    }

    public static ResponseVOBuilder aResponseVO() {
        return new ResponseVOBuilder();
    }

    public ResponseVOBuilder withCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResponseVOBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseVOBuilder withData(T data) {
        this.data = data;
        return this;
    }

    public ResponseVO build() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(code);
        responseVO.setMessage(message);
        responseVO.setData(data);
        return responseVO;
    }
}
