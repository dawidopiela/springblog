package pl.myblog.springblog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Entity
public class Comment {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @NotNull
    private  String message;
 private String author;

 private LocalDateTime date_added = LocalDateTime.now();

 @ManyToOne
    @JoinColumn(name = "post_id")
    private  Post post;

}
