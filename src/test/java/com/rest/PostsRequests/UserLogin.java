package com.rest.PostsRequests;

public class UserLogin {

    public String username;
    public String password;


    public String getUnauthorizedAccess(){
        username = "admin";
        password = "admin";
        return "Unauthorized";
    }
    public String getPassword(String password) {
        return password;
    }

    public String getUsername(String username) {
        return username;
    }
}
