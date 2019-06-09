package be.user.service.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest( UsersControllerImpl.class)
public class UsersControllerImplTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void searchUsers() throws Exception {
//        mockMvc.perform(get("/users/search"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(
//                        containsString("{\"email\":\"test@mail.ru\"")));
//    }

    @Test
    public void usersPost() {
    }

    @Test
    public void userLoginPost() {
    }
}