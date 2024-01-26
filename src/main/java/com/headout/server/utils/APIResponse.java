package com.headout.server.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

@ToString
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
public class APIResponse{
    private String data;
    private String message;
    private HttpStatus httpStatus;

    public void setData(String data) {
        this.data=data;

    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus=httpStatus;
    }

    public void setMessage(String message) {
        this.message=message;
    }
    public APIResponse(){

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
