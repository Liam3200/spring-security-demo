package greene.springdemo.springsecurityclient.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    //10 minutes till expiration
    private static final int EXPIRATION = 10;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
        nullable = false,
        foreignKey = @javax.persistence.ForeignKey(name = "FK_VERIFY_USER")
    )
    private User user;

    public VerificationToken(User user, String token) {
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = calculateExpirationTime();
    }

    public VerificationToken(String token) {
        super();
        this.token = token;
        this.expirationTime = calculateExpirationTime();
    }

    public Date calculateExpirationTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, EXPIRATION);

        return new Date(calendar.getTime().getTime());
    }
}
