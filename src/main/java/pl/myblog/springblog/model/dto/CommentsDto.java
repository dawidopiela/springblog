package pl.myblog.springblog.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class CommentsDto {

    @NotBlank
    private String message;
    @NotBlank
    private String author;

}
