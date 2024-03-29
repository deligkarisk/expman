package com.arilab.expman.domain.app;

import com.arilab.expman.domain.app.validator.OnInsert;
import com.arilab.expman.domain.app.validator.PasswordsMatch;
import com.arilab.expman.domain.app.validator.UniqueEmail;
import com.arilab.expman.domain.app.validator.UniqueUserName;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
// Excluding the roles is needed to avoid Stack overflow exceptions with lombock.
@ToString(exclude = {"roles"})
@RequiredArgsConstructor
@PasswordsMatch
@Table(name="users")
public class User  implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @UniqueEmail(groups = OnInsert.class)
    @NonNull
    @Size(min = 6, max = 25)
    @Column(nullable = false, unique = true)
    private String email;

    @UniqueUserName(groups = OnInsert.class)
    @NonNull
    @NotEmpty(message = "Please enter an alias")
    @Column(nullable = false, unique = true)
    private String username;

    @Column(length = 100)
    @NonNull
    private String password;

    @NonNull
    @Column(nullable = false)
    private boolean enabled;

    @NonNull
    @NotEmpty(message = "You must enter First Name.")
    private String firstName;

    @NonNull
    @NotEmpty(message = "You must enter Last Name.")
    private String lastName;

    @Column(name = "activation_code")
    private String activationCode;


    @NotEmpty(message = "Please enter the confirmation password")
    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();


    public void addRole(Role role) {
        roles.add(role);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    public String getFullName(){
        return firstName + " " + lastName;
    }




    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }



}