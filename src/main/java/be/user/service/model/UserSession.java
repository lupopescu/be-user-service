package be.user.service.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public  class UserSession {

    private String sessionId;

    private Long creationTime;

    private Long lastAccesTime ;

    private Integer maxInactiveInterval ;

    private User user;

}
