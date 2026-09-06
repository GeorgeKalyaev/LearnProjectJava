package org.example.api.tests;

import org.example.api.clients.ReqressClient;
import org.example.api.models.User;
import org.example.api.models.UserResponse;
import org.example.api.specs.ApiSpecs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqressTest {

    @BeforeEach
    void setUp() {
        ApiSpecs.setup();
    }
    @Test
    void getUserById(){
        int userId = 3;
        UserResponse userResponse = ReqressClient.getUser(userId);
        User user = userResponse.getData();
//        System.out.println(user.toString());
        System.out.println(user.getEmail());

        assertAll(
                () -> assertEquals("Emma", user.getFirstName(), "неверное имя пользователя"),
                () -> assertEquals("Wong1", user.getLastName(), "неверное фамилие пользователя")
        );


    }
}
