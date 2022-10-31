package com.revhalisi.appchurch.api.models;

public class LoginResult {
    private boolean error;
    private String message;
    private String token;
    private User user;


    public LoginResult(boolean error, String message,String token, User user) {
        this.error = error;
        this.message = message;
        this.token = token;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
    public String getToken(){
        return token;
    }

    public User getUser() {
        return user;
    }
}
