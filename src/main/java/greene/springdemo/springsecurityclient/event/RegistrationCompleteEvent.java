package greene.springdemo.springsecurityclient.event;

import org.springframework.context.ApplicationEvent;

import greene.springdemo.springsecurityclient.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String appUrl;

    public RegistrationCompleteEvent(User user, String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }
    
}
