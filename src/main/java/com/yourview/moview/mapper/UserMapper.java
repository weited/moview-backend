package com.yourview.moview.mapper;

import com.yourview.moview.dto.user.UserGetDto;
import com.yourview.moview.dto.user.UserGetSlimDto;
import com.yourview.moview.dto.user.UserPutDto;
import com.yourview.moview.dto.user.UserPostDto;
import com.yourview.moview.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User userPostDtoToUser(UserPostDto userPostDto);
    User userPutDtoToUser(UserPutDto userPutDto);
    UserGetDto userToUserGetDto(User user);
    UserGetSlimDto userToUserGetSlimDto(User user);
}
