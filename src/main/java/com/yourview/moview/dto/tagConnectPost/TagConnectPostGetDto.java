package com.yourview.moview.dto.tagConnectPost;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Tag.TagGetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagConnectPostGetDto {
    private Long id;

    private OffsetDateTime createdTime;

    private OffsetDateTime updatedTime;

    private PostGetDto postGetDto;

    private TagGetDto tagGetDto;
}
