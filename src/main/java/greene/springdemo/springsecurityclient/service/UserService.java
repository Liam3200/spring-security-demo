package greene.springdemo.springsecurityclient.service;

import greene.springdemo.springsecurityclient.entity.User;
import greene.springdemo.springsecurityclient.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationToken(User user, String token);
    
}
