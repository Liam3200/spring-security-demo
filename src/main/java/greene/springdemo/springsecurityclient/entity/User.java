package greene.springdemo.springsecurityclient.entity;

import jakarta.persistence.Entity;

@Entity
public class User {
    
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private boolean enabled = false;

    
}
