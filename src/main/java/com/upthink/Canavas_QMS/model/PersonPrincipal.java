package com.upthink.Canavas_QMS.model;import java.util.Collection;import java.util.stream.Collectors;import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.security.core.userdetails.UserDetails;public class PersonPrincipal implements UserDetails {    private final Person user;    public PersonPrincipal(Person user) {        this.user = user;    }    public Collection<? extends GrantedAuthority> getAuthorities() {        return (Collection)this.user.getGroups().stream().map((group) -> {            return new SimpleGrantedAuthority("ROLE_" + group.toUpperCase());        }).collect(Collectors.toList());    }    public String getPassword() {        return null;    }    public String getEmail() {        return this.user.getEmail();    }    public String getUsername() {        return this.user.getId();    }    public boolean isAccountNonExpired() {        return true;    }    public boolean isAccountNonLocked() {        return true;    }    public boolean isCredentialsNonExpired() {        return true;    }    public boolean isEnabled() {        return true;    }}