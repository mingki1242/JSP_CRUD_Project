package com.example.demo.news;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class NewsVO {
    int id;
    String writer;
    String title;
    LocalDateTime regdate;
    String body;
    int readcnt;

}
