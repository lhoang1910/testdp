package com.example.usermanager.domain.entity;

import com.example.usermanager.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String username;

    String adminName;

    String password;

    @Enumerated(EnumType.STRING)
    UserRole userRole = UserRole.ADMIN;

    Date createdAt;

    String createdBy;

    Date updatedAt;

    String lastUpdatedBy;


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
}
