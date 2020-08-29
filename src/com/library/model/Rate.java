package com.library.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.awt.print.Book;

@Builder
@Data
public class Rate {
    private long id;
    private long userId;
    private long bookId;
    private String score;
    private User user;
    private Book book;
}
