package com.splitwiseapp.dto.userDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDto {

    private Integer idUser;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;


}
