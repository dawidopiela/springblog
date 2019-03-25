package pl.myblog.springblog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @NotNull
    private  String message;
 private String author;

}
