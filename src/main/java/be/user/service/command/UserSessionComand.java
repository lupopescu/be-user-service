package be.user.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserSessionComand {
    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("creationTime")
    private Long creationTime;

    @JsonProperty("lastAccesTime")
    private Long lastAccesTime;

    @JsonProperty("maxInactiveInterval")
    private Integer maxInactiveInterval;

    @JsonProperty("user")
    private UserCommand user = null;
}
