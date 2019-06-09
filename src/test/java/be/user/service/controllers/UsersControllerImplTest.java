package be.user.service.controllers;

import be.user.service.command.UserCommand;
import be.user.service.exceptions.InvalidUsernameOrPasswordException;
import be.user.service.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersControllerImpl.class)
public class UsersControllerImplTest {

    MockMvc mockMvc;

    UsersControllerImpl usersController;

    @Mock
    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        usersController = new UsersControllerImpl(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(usersController)
                .build();
    }


    @Test
    public void searchUsers() throws Exception {

        UserCommand user = new UserCommand();
        user.setEmail("test2@mail.ru");
        List<UserCommand> command = new ArrayList<>();
        command.add(user);
        when(userService.getAllUsers()).thenReturn(command);

        MockHttpServletResponse response = mockMvc.perform(get("/users/search"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":null,\"email\":\"test2@mail.ru\",\"phoneNumber\":null,\"password\":null}]")))
                .andReturn().getResponse();

    }

    @Test
    public void usersPost() throws Exception {
//       UserCommand command = new UserCommand();
//        command.setEmail("test5@mail.ru");
//        command.setPassword("2365895456");
//        command.setId( UUID.randomUUID().toString());
//
//
//        //when
//        when(userService.save(any(UserCommand.class))).thenReturn((command));
//
//        //then
//        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
//                .requestAttr("user", command)
//
//        )
//
//                .andExpect(status().isOk())
//                .andReturn().getResponse();

    }

    @Test
    public void userLoginPost() {
    }
}