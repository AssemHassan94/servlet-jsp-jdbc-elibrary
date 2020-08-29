package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class Role {
    private long id;
    private String role;


}
