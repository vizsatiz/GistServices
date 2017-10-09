package com.gist.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    @NotNull
    @NotEmpty
    @Size(max = 20, min = 3, message = "{USER_NAME_INVALID}")
    private String username;

    @Column(name = "USER_MOBILE", unique = true)
    @NotNull
    @NotEmpty
    @Size(max = 10, min = 10, message = "{USER_NAME_INVALID}")
    private String mobile;

    @Column(name = "USER_PROFILE_PIC_URL", unique = true)
    private String profilePicUrl;

    @Column(name = "USER_LEVEL")
    private int level;

    @Column(name = "USER_LOCATION")
    private String location;

    public User() {

    }

    public User(Long id, String username, String mobile) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
