package com.yourview.moview.dto.user;

import com.yourview.moview.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserGetDto {
    private long id;
    private Role role;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String profileImgUrl;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
