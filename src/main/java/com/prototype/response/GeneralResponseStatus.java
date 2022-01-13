package com.prototype.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponseStatus implements Serializable {

    private String code;

    private String message;

    public GeneralResponseStatus(ResponseStatusEnum responseStatusEnum) {
        this.code = responseStatusEnum.getCode();
        this.message = responseStatusEnum.getMessage();
    }
}

@Getter
enum ResponseStatusEnum {

    SUCCESS("SUCCESS", "Request successfully"),
    UNKNOWN_ERROR("UNKNOWN_ERROR", "Can not specify error");

    private final String code;
    private final String message;

    ResponseStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
