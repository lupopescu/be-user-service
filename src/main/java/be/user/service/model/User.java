package be.user.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
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
