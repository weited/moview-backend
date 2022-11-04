package com.yourview.moview.dto.user;

import com.yourview.moview.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserGetDto {
    private long id;
    private Set<Role> roles;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String profileImgUrl;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
