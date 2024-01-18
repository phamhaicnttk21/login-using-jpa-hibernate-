package com.example.login.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Passwords")
    private String Passwords;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(
            name = "id",referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "roleId" ,referencedColumnName = "id"))
    private Collection<Role> roles;
    public User(){

    }




    public User(String firstName, String lastName, String email, String passwords, Collection<Role> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        Passwords = passwords;
        this.roles=roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasswords() {
        return Passwords;
    }

    public void setPasswords(String passwords) {
        Passwords = passwords;
    }
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
