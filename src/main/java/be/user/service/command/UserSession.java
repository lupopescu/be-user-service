package be.user.service.command;

import be.user.service.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document
public class UserSession {

    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("creationTime")
    private Long creationTime;

    @JsonProperty("lastAccesTime")
    private Long lastAccesTime ;

    @JsonProperty("maxInactiveInterval")
    private Integer maxInactiveInterval ;

    @JsonProperty("user")
    private User user;

}
