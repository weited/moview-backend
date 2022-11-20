package com.yourview.moview.dto.Post;

import com.yourview.moview.dto.user.UserGetSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostReactionDto {
    private Long id;
    private UserGetSlimDto currentUser;
    private boolean like;
    private boolean favorite;
}
