package com.library.user_service.dto;

import issuedbooks.GetIssuedBooksResponse;

import java.util.List;

public class UserResponseDTO {
    private Integer id;
    private String user;
    private List<IssuedbookDTO> issuedBooks;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer id, String user, List<IssuedbookDTO> issuedBooks) {
        this.id = id;
        this.user = user;
        this.issuedBooks = issuedBooks;
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

    public List<IssuedbookDTO> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<IssuedbookDTO> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }
}
