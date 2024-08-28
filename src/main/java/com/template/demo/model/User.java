package com.template.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends OidcUserInfo implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    /**
     * Constructs a {@code OidcUserInfo} using the provided parameters.
     *
     * @param claims the claims about the authentication of the End-User
     */
    public User(final Map<String, Object> claims) {
        super(claims);
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
