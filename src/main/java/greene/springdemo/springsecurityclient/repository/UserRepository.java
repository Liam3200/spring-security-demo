package greene.springdemo.springsecurityclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import greene.springdemo.springsecurityclient.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
