package com.library.user_service.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank(message = "User name cannot be blank")
    private String user;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Local ID cannot be blank")
    private String lId;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String user, String password, String lId) {
        this.user = user;
        this.lId = lId;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }
}
