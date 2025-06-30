package com.library.user_service.dto;

public class UserResponseDTO {
    private Integer id;
    private String user;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer id, String user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
