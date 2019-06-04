package be.user.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class UserCommand {

    @JsonProperty("id")
    private String id ;

    @JsonProperty("email")
    private String email ;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("password")
    @Min(6)
    @Max(12)
    private String password;


}
