package com.library.user_service.exception;

public class UserNotFindException extends RuntimeException{
    public UserNotFindException(Integer id) {
        super(id + " not found");
    }
}
