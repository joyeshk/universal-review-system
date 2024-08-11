package com.jk.universalreview.users.DTO;

import com.jk.universalreview.users.DTO.external.Reviews;
import com.jk.universalreview.users.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UserDTO {
    private String user_id;
    private String first_name;
    private String last_name;
    private String email;
    private List<Reviews> reviews;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public UserDTO(String user_id, String first_name, String last_name, String email, List<Reviews> reviews) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.reviews = reviews;
    }

    public UserDTO(User user) {
        this.user_id = user.getUser_id();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
    }

    public UserDTO() {
    }
}
