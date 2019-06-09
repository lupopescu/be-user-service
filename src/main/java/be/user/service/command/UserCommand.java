package be.user.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @NonNull
    private String email ;

    @JsonProperty("phoneNumber")
    @NonNull
    private String phoneNumber;

    @JsonProperty("password")
    @Min(6)
    @Max(12)
    @NonNull
    private String password;


}
