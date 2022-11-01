package com.yourview.moview.dto.Tag;

import com.yourview.moview.dto.Post.PostGetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagGetDto {
    private Long id;
    private String name;
    private List<PostGetDto> postList;
}
