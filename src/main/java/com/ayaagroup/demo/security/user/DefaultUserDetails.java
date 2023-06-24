package com.ayaagroup.demo.security.user;

import com.ayaagroup.demo.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

// Note: Mafrood meen ely hy7ad el values bt3t isAccountNonExpired we ba2y el field deh ???
@RequiredArgsConstructor
@Setter
public class DefaultUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getPassword() {
        return user.getUserPass();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        var setOfGrantedAuthorities = user.getAuthorities().stream().map(SecurityAuthority::new).collect(Collectors.toList());
        return setOfGrantedAuthorities;
    }



    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
