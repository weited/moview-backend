package com.yourview.moview.mapper;

import com.yourview.moview.dto.user.*;
import com.yourview.moview.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User userPostDtoToUser(UserPostDto userPostDto);

    User userPutDtoToUser(UserPutDto userPutDto);

    UserGetDto userToUserGetDto(User user);

    UserInfoDto userToUserInfoDto(User user);

    UserGetSlimDto userToUserGetSlimDto(User user);
}
