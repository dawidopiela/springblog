package pl.myblog.springblog.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity                                                 //tworzy tabelke w DB
public class User {

    @Id                                                 //Pk
    @GeneratedValue(strategy = GenerationType.AUTO)     //AI
    private  Long id;
//    @NotNull                                             //NN
    private String name;
//    @NotNull
    private String lastname;
//    @Email
//    @NotNull
    private String email;
//    @Length(min=6)
//    @Pattern(regexp = "([A-Z]+.*[0-9]+|[0-9]+.*[A-Z])") // co najmniej 1XCL 1X
    private String password;

    private Boolean active = true;
    private LocalDateTime registered_date = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "user_role",                                     //nazwa tabelki N:M
            joinColumns =  @JoinColumn (name = "user_id"),          //nazwa kolumny 1
            inverseJoinColumns = @JoinColumn(name = "role_id"))     //nazwa kolumny 2
    Set<Role> roles = new HashSet<>();                              //zbior rol

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
   private Set<Post> posts = new HashSet<>();
//metoda dodajaca posta do uzytkownika
public void addPost(Post post){
    this.posts.add(post);
}


}
