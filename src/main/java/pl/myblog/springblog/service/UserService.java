package pl.myblog.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.myblog.springblog.model.User;
import pl.myblog.springblog.model.dto.UserDto;
import pl.myblog.springblog.repository.RoleRepository;
import pl.myblog.springblog.repository.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    @Autowired

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }





    public User addUser(UserDto userDto){
        //wprowadzenie wartosci z userDTo do user
        User user = new User();
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        //szyfrowanie za pomoca bCrypt
        String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
        user.setPassword(encodedPassword);
        //przypisanie obiektu roli o Id 1 ->User
        user.addRole(roleRepository.getOne((long)1));

        return userRepository.save(user);
    }
public Boolean isAdmin(Authentication auth) {
    UserDetails principal = (UserDetails) auth.getPrincipal();
    String email = principal.getUsername();
    User user = userRepository.findByEmail(email);
    if (user.getRoles().contains(roleRepository.getOne((long) 2))) {
        return true;
    }
return false;
}
public User getUserById(Authentication auth){

        UserDetails principal= (UserDetails) auth.getPrincipal();
        String email =principal.getUsername();
        return userRepository.findByEmail(email);
}
}
