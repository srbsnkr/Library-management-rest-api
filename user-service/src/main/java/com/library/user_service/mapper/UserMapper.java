package com.library.user_service.mapper;

import com.library.user_service.dto.UserRequestDTO;
import com.library.user_service.dto.UserResponseDTO;
import com.library.user_service.entity.User;

public class UserMapper {

    public static UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUser(user.getUser());
        return userResponseDTO;
    }

    public static User toUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUser(userRequestDTO.getUser());
        user.setlId(userRequestDTO.getlId());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }
}
