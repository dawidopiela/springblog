package pl.myblog.springblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.myblog.springblog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Select * from user where email?
   User findByEmail(String email);
    //select * FROM user WHERE EMAIL = ? And password=?
     User findByEmailAndPassword(String email, String password);

}
