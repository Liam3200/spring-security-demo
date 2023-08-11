package greene.springdemo.springsecurityclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import greene.springdemo.springsecurityclient.entity.User;
import greene.springdemo.springsecurityclient.entity.VerificationToken;
import greene.springdemo.springsecurityclient.model.UserModel;
import greene.springdemo.springsecurityclient.repository.UserRepository;
import greene.springdemo.springsecurityclient.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstname(userModel.getFirstname());
        user.setLastname(userModel.getLastname());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }


    
}