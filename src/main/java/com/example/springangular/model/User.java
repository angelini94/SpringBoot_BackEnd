package com.example.springangular.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @NotEmpty
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotEmpty
    @Column(name = "country", nullable = false)
    private String country;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past @NotNull
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "image")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_skill",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_skill") })
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

    public User() {
    }

    public User(@NotEmpty String firstname, @NotEmpty String lastname, @NotEmpty String country, @Past @NotNull Date birthdate, String fileName, @NotNull Role role, @NotNull Status status, Set<Skill> skills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.birthdate = birthdate;
        this.fileName = fileName;
        this.role = role;
        this.status = status;
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(country, user.country) &&
                Objects.equals(birthdate, user.birthdate) &&
                Objects.equals(fileName, user.fileName) &&
                Objects.equals(role, user.role) &&
                Objects.equals(status, user.status) &&
                Objects.equals(skills, user.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, country, birthdate, fileName, role, status, skills);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", birthdate=" + birthdate +
                ", fileName='" + fileName + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", skills=" + skills +
                '}';
    }
}
