package TabletopNexus.Login.controllers;

import TabletopNexus.Login.Classes.*;
import TabletopNexus.Login.Services.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> CreateAccount(@RequestBody User user, HttpServletResponse response){
       String token = loginService.register(user);
       if (!token.equals("username in use") && !token.equals("password not complex")) {
           Cookie cookie = new Cookie("AuthToken", token);
           cookie.setMaxAge(8400);
           cookie.setPath("/");
           response.addCookie(cookie);
           Cookie username = new Cookie("username", user.getUsername());
           username.setMaxAge(8400);
           username.setPath("/");
           response.addCookie(username);
           return new ResponseEntity<>("Congratulations You are Registered", HttpStatus.CREATED);
       }
       else return new ResponseEntity<>(token,HttpStatus.CONFLICT);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody Credentials namepass, HttpServletResponse response){
        String token = loginService.logIn(namepass);
        if (!token.equals("User Not Found") && !token.equals("Password Doesn't Match")) {
            Cookie cookie = new Cookie("AuthToken", token);
            cookie.setMaxAge(8400);
            cookie.setPath("/");
            response.addCookie(cookie);
            Cookie username = new Cookie("username", namepass.getCredFieldOne());
            username.setMaxAge(8400);
            username.setPath("/");
            response.addCookie(username);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(token,HttpStatus.CONFLICT);
        }

    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username, @RequestParam("AuthToken") String authToken){
        System.out.println("GetUser Has been Reached");

        return new ResponseEntity<>(loginService.getUserInfo(username,authToken),HttpStatus.OK);
    }
    @GetMapping(path = "/logout/{username}")
    public ResponseEntity<String> logout(@PathVariable String username, @RequestParam("AuthToken")  String token){
        loginService.logout(username,token);

       return new ResponseEntity<>("Log out Successful",HttpStatus.OK);
    }

    @PutMapping(path = "/changePassword/{username}")
    @ResponseStatus(code = HttpStatus.OK)
    public String changePassword(@PathVariable String username, @RequestBody Credentials credentials, @RequestParam("AuthToken") String authToken){

        return loginService.changePassword(username, credentials);
    }

    @DeleteMapping(path = "/delete/{username}")
    public ResponseEntity<String> deleteAccount(@PathVariable String username, @RequestParam("AuthToken") String AuthToken, @RequestParam String password){

        password = password.trim();

        String token = loginService.deleteUser(username,password,AuthToken);

        if (!token.equals("Password Doesn't Match") && !token.equals("Account Doesn't Exist")) {
        return new ResponseEntity<>(token,HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(token,HttpStatus.CONFLICT);
        }
    }

    @GetMapping(path = "/{username}/characters")
    public ResponseEntity<List<UUID>> characters(@PathVariable String username, @CookieValue("AuthToken") String authToken) {
        List<UUID> characterIDs = loginService.getUserCharacters(username);

        return new ResponseEntity<>(characterIDs,HttpStatus.OK);
    }

    @PostMapping(path = "/{username}/character")
    public ResponseEntity<String> addCharacter(@PathVariable String username, @RequestParam UUID characterId, @RequestParam("AuthToken") String authToken){

        loginService.addCharacter(username,characterId, authToken);

        return new ResponseEntity<>("Added",HttpStatus.OK);
    }

    @DeleteMapping(path = "/{username}/character")
    public ResponseEntity<String> deleteCharacter(@PathVariable String username, @RequestParam UUID characterId, @RequestParam("AuthToken") String authToken){

        loginService.deleteCharacter(username,characterId, authToken);

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}


