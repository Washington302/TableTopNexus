package TabletopNexus.Login.Classes;

import TabletopNexus.Login.Models.ArsCharacter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RedisHash("User")
public class User  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    String username;
    String password;
    String email;
    String salt;
    List<UUID> characters = new ArrayList<>();
    String AuthToken;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UUID> getCharacters() {
        return characters;
    }

    public String getAuthToken() {
        return AuthToken;
    }

    public void setAuthToken(String authToken) {
        AuthToken = authToken;
    }
}
