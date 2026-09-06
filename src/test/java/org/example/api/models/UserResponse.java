package org.example.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private User data;

    public User getData() {
        return data;
    }

    public void setData(){
        this.data = data;
    }
}
