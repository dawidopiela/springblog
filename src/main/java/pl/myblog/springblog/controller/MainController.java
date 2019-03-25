package pl.myblog.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.myblog.springblog.model.User;
import pl.myblog.springblog.service.MainService;

import java.util.List;

@RestController // restcontroller zeby nie wyswietlac w grafice
@RequestMapping("/rest")
public class MainController {

    MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")  //adres domowy
    public String home(){
        return "Hello my Blog!";
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return mainService.getallUsers();                    //wykonac zapytanie SQL
}
    @GetMapping("/users/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return  mainService.getUserByEmail(email);

    }

    @GetMapping("/users/count")
    public Long countAllUsers(){
        return mainService.countAllUsers();
    }
    @GetMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id")Long id){
        mainService.updateUserActivityById(id);
        return "Zmieniono aktywnosc";
    }
    @GetMapping("/login/{email}/{password}")
    public String loginCheck(
                 @PathVariable("email") String email,
                @PathVariable("password") String password){
    //zwraca usera lub null
    User user = mainService.login(email, password);
    return(user !=null) ? user.toString():"Błąd logowanai";

    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        mainService.deleteUserUserById(id);
        return "Usunieto";
    }
    @GetMapping("/post/add/{id}/{title}/{content}")
    public String addPost(
        @PathVariable("id") Long id,
                @PathVariable("title") String title,
                @PathVariable("content") String content) {
        mainService.addPost(id,title,content);
        return "Dodano posta";
    }

}
