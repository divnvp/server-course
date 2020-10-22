package ru.mip.database.models;

import ru.mip.database.dto.UsersDto;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String fathername;
    private String username;
    private String status;
    private String password;

    public Users(String firstname, String lastname, String fathername, String username, String status, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fathername = fathername;
        this.username = username;
        this.status = status;
        this.password = password;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersDto toDto(){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(id);
        usersDto.setFirstname(firstname);
        usersDto.setLastname(lastname);
        usersDto.setFathername(fathername);
        usersDto.setStatus(status);
        usersDto.setUsername(username);
        usersDto.setPassword(password);
        return usersDto;
    }
}
