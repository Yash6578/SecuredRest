package com.practice.securedrest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long id;

    @Column(name = "user_name", unique = true)
    String userName;

    @Column(name = "user_password")
    String passwd;

    @Column(name = "user_role")
    String role;

    @Column(name = "user_enabled")
    boolean enabled;

    @Column(name = "user_account_non_expired")
    boolean accountNonExpired;

    @Column(name = "user_credential_non_expired")
    boolean credentialNonExpired;

    @Column(name = "user_account_non_locked")
    boolean accountNonLocked;
}
