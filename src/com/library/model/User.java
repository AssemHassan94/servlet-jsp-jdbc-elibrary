package com.library.model;

import com.library.annotation.JsonSerializable;
import com.library.annotation.JsonElement;
import com.library.annotation.Init;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@JsonSerializable
public class User {
    @JsonElement
    private long id;
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement
    private String email;
    private String password;
    private long roleId;

    @Init
    private void initNames() {

    }
}
