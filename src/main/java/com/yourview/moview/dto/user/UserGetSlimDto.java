package com.yourview.moview.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserGetSlimDto {
    private long id;
    private String username;
    private String profileImgUrl;
}
