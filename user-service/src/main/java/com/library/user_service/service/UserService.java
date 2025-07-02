package com.library.user_service.service;

import com.library.user_service.dto.IssuedbookDTO;
import com.library.user_service.dto.UserRequestDTO;
import com.library.user_service.dto.UserResponseDTO;
import com.library.user_service.entity.User;
import com.library.user_service.mapper.IssuedbookMapper;
import com.library.user_service.mapper.UserMapper;
import com.library.user_service.repository.UserRepository;
import com.library.user_service.grpc.IssuedbooksServiceGrpcClient;
import issuedbooks.GetIssuedBooksResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final IssuedbooksServiceGrpcClient issuedbooksServiceGrpcClient;

    public UserService(UserRepository userRepository,
                       IssuedbooksServiceGrpcClient issuedbooksServiceGrpcClient) {
        this.userRepository = userRepository;
        this.issuedbooksServiceGrpcClient = issuedbooksServiceGrpcClient;

    }

    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll().stream().map(
                UserMapper::toUserResponseDTO).toList();
    }

    public UserResponseDTO getUserById(Integer id) {
        UserResponseDTO response =  userRepository.findById(id)
                .map(UserMapper::toUserResponseDTO)
                .orElse(null);
        if (response != null) {
            try {
                // Call gRPC microservice to get books issued to the user
                List<GetIssuedBooksResponse> books = List.of(issuedbooksServiceGrpcClient.getIssuedBookDetails(String.valueOf(id)));
                log.info("Retrieved issued books for user with ID: {}", id);
                log.info("Book details: {}", books);
                // Add the gRPC response to your DTO
                List<IssuedbookDTO> issuedBooks = books.stream()
                        .map(IssuedbookMapper::fromGrpc)
                        .toList();
                response.setIssuedBooks(issuedBooks);
            } catch (Exception e) {
                log.error("Error: {}", e.getMessage());
                return null; // or throw a custom exception
            }
        }
        log.info("User with ID {} retrieved successfully", id);
        log.info("User details: {}", response);
        return response;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = UserMapper.toUser(userRequestDTO);
        userRepository.save(user);
        return UserMapper.toUserResponseDTO(user);
    }

}
