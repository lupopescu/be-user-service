package be.user.service.model;


import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Getter
@Setter
@Document
public class User {

    private String id = UUID.randomUUID().toString();

    private String email;

    private String phoneNumber;

    private String password;


}
