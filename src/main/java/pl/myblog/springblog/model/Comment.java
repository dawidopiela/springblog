package pl.myblog.springblog.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @NotNull
    private  String message;
 private String author;

 @ManyToOne
    @JoinColumn(name = "post_id")
    private  Post post;

}
