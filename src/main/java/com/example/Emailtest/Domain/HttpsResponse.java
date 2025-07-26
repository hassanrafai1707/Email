package com.example.Emailtest.Domain;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class HttpsResponse {
    private String timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String message;
    private Map<?, ?> data;
}