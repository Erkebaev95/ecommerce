package com.erkebaev.dnsshop.security;

import com.erkebaev.dnsshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomerDetailImpl implements UserDetails {

    private final Customer customer;

    @Autowired
    public CustomerDetailImpl(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*GrantedAuthorityImpl grantedAuthority =
                new GrantedAuthorityImpl("admin", true);

        ArrayList<GrantedAuthorityImpl> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(grantedAuthority);*/

        return Collections.singletonList(
                new SimpleGrantedAuthority(customer.getRole().getServiceName())); // будем получать роли
    }

    @Override
    public String getPassword() {
        return this.customer.getPassword();
    }

    @Override
    public String getUsername() {
        return this.customer.getLogin();
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

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public Customer getUser() {
        return this.customer;
    }
}
