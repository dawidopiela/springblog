package pl.myblog.springblog.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
public class UserDto {


    @NotNull                                             //NN
    private String name;
    @NotNull
    private String lastname;
    @Email
    @NotNull
    private String email;
    @Length(min=6)
    @Pattern(regexp = "([A-Z]+.*[0-9]+|[0-9]+.*[A-Z])") // co najmniej 1XCL 1X
    private String password;
}
