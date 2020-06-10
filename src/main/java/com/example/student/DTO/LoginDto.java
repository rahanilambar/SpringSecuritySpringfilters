package com.example.student.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author nilambar
 */
public class LoginDto {
    @NotBlank
    private String name;
    @NotBlank
    private String password;

    public LoginDto(){}
    public LoginDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
