package pl.myblog.springblog.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;




@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @Type(type = "text")                    // longtext
    private String content;
    @Enumerated
    private PostCategory category;
    private LocalDateTime date_added = LocalDateTime.now();

    // FetchType.LAZY       - dane zostaną odczytane z bazy dopiero w momencie gdy nastąpi odwołanie do obiektu
    // FetchType.EAGER      - dane zostaną odczytane z bazy natychmiast po utworzeniu obiektu nadrzędnego
    // CascadeType.PERSIST
    // CascadeType.MERGE
    //
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

    public Post(String title, String content, PostCategory category, User user) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.user = user;
    }
    public Post() {
    }
public void addComment(Comment comment){
        this.comments.add(comment);
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostCategory getCategory() {
        return category;
    }

    public void setCategory(PostCategory category) {
        this.category = category;
    }

    public LocalDateTime getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDateTime date_added) {
        this.date_added = date_added;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}