package be.user.service.model;

import lombok.*;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Document
public  class UserSession {

    private String sessionId= UUID.randomUUID().toString();

    private Long creationTime;

    private Long lastAccesTime ;


    @DBRef
    @Field("user")
    private User user;

}
