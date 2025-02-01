package com.isaagerald.blog_post.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {

    private int status;

    private String message;

    private ZonedDateTime timeStamp;

}
