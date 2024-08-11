package com.jk.universalreview.users.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class emailChangeDTO {
    @NotBlank(message = "User ID required")
    private String user_id;
    @NotBlank(message = "Email is required")
    @Email(message = "Enter Valid Email Address")
    private String email;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
