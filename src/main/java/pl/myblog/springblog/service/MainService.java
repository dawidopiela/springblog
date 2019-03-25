package pl.myblog.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.myblog.springblog.model.Post;
import pl.myblog.springblog.model.PostCategory;
import pl.myblog.springblog.model.User;
import pl.myblog.springblog.repository.PostRepository;
import pl.myblog.springblog.repository.UserRepository;
import sun.security.util.Password;

import java.util.List;

@Service
public class MainService {

    UserRepository userRepository;
     PostRepository postRepository;

    public MainService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Autowired




                                 //wstrzykniecie zaleznosci prze konstruktor
    public MainService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public List<User> getallUsers(){
        return userRepository.findAll();        //select * from user
    }
    // end- point zwracajacy uzytkownika o zadanym adresie emial

    public User getUserByEmail( String email){
        return userRepository.findByEmail(email);                                              //Select * from user Where email= ?
    }

    //End-Point zwracajacy liczbe uzytkownikow
    public Long countAllUsers(){
        return userRepository.count();
    }
// end- point zmieniajacy aktywnosc uzytkownika
    public void updateUserActivityById(Long id){
        User user = userRepository.getOne(id);
        user.setActive(!user.getActive());
        //Update user
        userRepository.save(user);
    }
// end point zwracajacy wynik logowoania
    public User login(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }
// end point usuwajacy uzytkownika po id
    public void deleteUserUserById(Long id){
       userRepository.deleteById(id);


    }

    // END-POINT utworzenie nowego posta
    public void addPost(Long id, String title, String content){
        // szukamy usera po ID
        User user = userRepository.getOne(id);
        // utwórz obiekt posta
        Post post = new Post(title, content, PostCategory.PROGRAMOWANIE, user);
        // dodaj posta do zbioru postów obkietu user
        user.addPost(post);
        postRepository.save(post);
    }
}
