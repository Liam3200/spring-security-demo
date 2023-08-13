package greene.springdemo.springsecurityclient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import greene.springdemo.springsecurityclient.entity.User;
import greene.springdemo.springsecurityclient.event.RegistrationCompleteEvent;
import greene.springdemo.springsecurityclient.model.UserModel;
import greene.springdemo.springsecurityclient.service.UserService;


@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        eventPublisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationURL(request)));
        return "Success!";
    }

    private String applicationURL(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}
