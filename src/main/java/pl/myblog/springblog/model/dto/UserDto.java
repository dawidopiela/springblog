package pl.myblog.springblog.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
public class UserDto {


    @NotBlank(message = "Insert your name")                                           //NN
    private String name;
    @NotBlank(message = "Insert your lastname" )
    private String lastname;
    @Email(message = "You email is not valid")
    @NotBlank(message = "Insert your email")
    private String email;
    @Length(min=6, message = "Your password requires at least 6 characters")
   @Pattern(regexp = "([A-Z]+.*[0-9]+|[0-9]+.*[A-Z])") // co najmniej 1XCL 1X
    private String password;
}
