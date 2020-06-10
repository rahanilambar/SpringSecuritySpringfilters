package com.example.student.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nilambar
 */
public class UserDto {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String section;
    @NotBlank
    private String role;

    public UserDto(){}

    public UserDto(String name, String password, String section, String role) {
        this.name = name;
        this.password = password;
        this.section = section;
        this.role = role;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
        
}
