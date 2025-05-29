package com.handbook.handbookapi.user;

import com.handbook.handbookapi.user.role.Role;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDTO {

    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static UserDTO fromEntity(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRoles(user.getRoles());

        return dto;
    }

    public User toEntity() {
        User user = new User();
        user.setUsername(this.getUsername());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        user.setRoles(this.getRoles());

        return user;
    }
}
