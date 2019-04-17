package api.testing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private String username;
    private String password;

    @JsonProperty("real_name")
    private String realName;
    private String email;

    @JsonProperty("access_level")
    private UserAccessLevel accessLevel;
    private boolean enabled;

    @JsonProperty("protected")
    private boolean userProtected;

}
