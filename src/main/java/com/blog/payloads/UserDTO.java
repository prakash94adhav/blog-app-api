package com.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private int id;
    @NotEmpty
    @Size(min = 4,message = "username must be min of 4 char")
    private String name;
    @Email(message = "email is not valid")
    private String email;
    @NotEmpty
    @Size(min = 4,max = 10,message = "password must be 4 char and max of 10")
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;
    @NotEmpty
    private String about;
}
