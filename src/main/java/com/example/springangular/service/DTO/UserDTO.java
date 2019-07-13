package com.example.springangular.service.DTO;

import com.example.springangular.model.Role;
import com.example.springangular.model.Skill;
import com.example.springangular.model.Status;
import com.example.springangular.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String country;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    private String fileName;
    private Role role;
    private Status status;
    private Set<Skill> skills = new HashSet<Skill>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.firstname = u.getFirstname();
        this.lastname = u.getLastname();
        this.country = u.getCountry();
        this.birthdate = u.getBirthdate();
        this.fileName = u.getFileName();
        this.role = u.getRole();
        this.status = u.getStatus();
        this.skills = u.getSkills();
    }

    public UserDTO() {
    }
}
