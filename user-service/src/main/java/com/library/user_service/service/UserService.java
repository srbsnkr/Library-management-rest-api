package com.library.user_service.service;

import com.library.user_service.dto.UserRequestDTO;
import com.library.user_service.dto.UserResponseDTO;
import com.library.user_service.entity.User;
import com.library.user_service.mapper.UserMapper;
import com.library.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll().stream().map(
                UserMapper::toUserResponseDTO).toList();
    }

    public UserResponseDTO getUserById(Integer id) {
        return userRepository.findById(id)
                .map(UserMapper::toUserResponseDTO)
                .orElse(null);
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = UserMapper.toUser(userRequestDTO);
        userRepository.save(user);
        return UserMapper.toUserResponseDTO(user);
    }

}
