package com.library.model;



import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private long id;
    private String title;
    private String author;
}
