package TabletopNexus.Login.Services;

import TabletopNexus.Login.Classes.*;
import TabletopNexus.Login.Repositories.LoginRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginService {



    @Autowired
    LoginRepository loginRepo;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final java.util.Base64.Encoder base64Encoder = java.util.Base64.getUrlEncoder();

    public String logIn(Credentials creds){

        if (loginRepo.findById(creds.getCredFieldOne()).isPresent()) {


            User user = loginRepo.findById(creds.getCredFieldOne()).get();

            String salt = user.getSalt();
            assert user != null;
            String password = creds.getCredFieldTwo();

            if (user.getPassword().equals(getSHA256(password, salt))) {
                user.setAuthToken(generateNewToken());
                loginRepo.save(user);

                return user.getAuthToken();
            } else {
                return "Password Doesn't Match";
            }
        } else {
            return "User Not Found";
        }

    }

    public String register(User user){
        //redisTemplate.opsForValue().get(user.getUsername()) == null
        if(!loginRepo.findById(user.getUsername()).isPresent()) {

            String password = user.getPassword();

            user.setSalt(bytetoString());

            String salt = user.getSalt();

            if (!passwordComplexityChecker(password)) {
                return "password not complex";
            } else {
                user.setPassword(getSHA256(password, salt));

                user.setAuthToken(generateNewToken());

                loginRepo.save(user);
                //redisTemplate.opsForValue().set(user.getUsername(), user);

                return user.getAuthToken();
            }
        }
       else{
            return "username in use";
        }
    }

    public void logout(String user, String authToken){

        User currentUser = loginRepo.findById(user).get();
        if(currentUser.getAuthToken().equals(authToken)){
            currentUser.setAuthToken(null);
            loginRepo.save(currentUser);
        }
    }

    public User getUserInfo(String username, String authToken){
        User user = loginRepo.findById(username).get();
        if (user.getAuthToken().equals(authToken)){
            return user;
        }else{
            return null;
        }
    }

    public String changePassword(String username, Credentials credentials){

        User user  = loginRepo.findById(username).get();

        assert user != null;
        String password = credentials.getCredFieldOne();

            System.out.println(user.getPassword());

            System.out.println(getSHA256(password,user.getSalt()));

            if (user.getPassword().equals(getSHA256(credentials.getCredFieldOne(),user.getSalt()))) {
            user.setPassword(getSHA256(credentials.getCredFieldTwo(),user.getSalt()));
            loginRepo.save(user);
            return "password Updated Successfully";
        }
        else{
            return "password doesn't match";
        }
    }

    public String deleteUser(String username,String password, String AuthToken){
        if (loginRepo.findById(username).isPresent()){
           User user = loginRepo.findById(username).get();

           if (user.getPassword().equals(getSHA256(password,user.getSalt())) && user.getAuthToken().equals(AuthToken)){
               loginRepo.delete(user);
               return "Account Deleted Successfully";
           }else {
               return "Password Doesn't Match";
            }
        }else {
            return "Account Doesn't Exist";

        }
    }
    public List<UUID> getUserCharacters(String username) {

        if(loginRepo.findById(username).isPresent()){
            User user = loginRepo.findById(username).get();

           return user.getCharacters();

        }else {
            return null;
        }
    }


    public void addCharacter(String username, UUID characterId, String authToken) {
    if (loginRepo.findById(username).isPresent()){

        User user = loginRepo.findById(username).get();

        if (user.getAuthToken().equals(authToken)){
            if(!user.getCharacters().contains(characterId)){
                user.getCharacters().add(characterId);
                loginRepo.save(user);
            }
        }
    }
    }

    public void deleteCharacter(String username, UUID characterId, String authToken) {
        if (loginRepo.findById(username).isPresent()){

            User user = loginRepo.findById(username).get();

            if (user.getAuthToken().equals(authToken)){
                if(user.getCharacters().contains(characterId)){
                    user.getCharacters().remove(characterId);
                    loginRepo.save(user);
                }
            }
        }
    }










    public byte[] createSalt(){
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }

    public String bytetoString() {


        return Base64.encodeBase64String(createSalt());
    }

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    String getSHA256(String clearText, String salt) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            clearText+= salt;


            byte[] messageDigestBytes = messageDigest.digest(clearText.getBytes());


            BigInteger bigInt =  new BigInteger(1, messageDigestBytes);

            StringBuilder hash = new StringBuilder(bigInt.toString(16));
            while (hash.length() < 32){
                hash.insert(0, "0");
            }
            return hash.toString();
        }
        catch (Exception e){
            return e.toString();
        }

    }

    public boolean passwordComplexityChecker(String password){

        Pattern complexityChecker = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,40})");

        Matcher matcher = complexityChecker.matcher(password);
        boolean matchFound = matcher.find();

        return matchFound;
    }

}
