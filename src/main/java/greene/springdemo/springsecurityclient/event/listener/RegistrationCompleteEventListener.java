package greene.springdemo.springsecurityclient.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import greene.springdemo.springsecurityclient.entity.User;
import greene.springdemo.springsecurityclient.event.RegistrationCompleteEvent;
import greene.springdemo.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the varification token for the user
        //send the email
        User user = event.getUser();
        String token = UUID.randomUUID().toString(); 
        userService.saveVerificationToken(user, token); 
        
        String confirmationUrl = event.getAppUrl() + "verfiyRegistration?token=" + token;

        //sendVerificationEmail(user.getEmail(), confirmationUrl);
        log.info("click the link to confirm your registration: " + confirmationUrl);
    }
    
}
