package pl.myblog.springblog.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @Type(type = "text")
    private String content;
    @Enumerated
    private PostCategory category;
    private LocalDateTime date_added = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
   private User user;
// mapownaie user

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "post")
private Set<Comment> comments = new HashSet<>();

    public Post( String title, String content, PostCategory category, User user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
    }

    public String getUser() {
    return "Name:" + user.getName();
}
}
