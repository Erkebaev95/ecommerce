package com.erkebaev.dnsshop.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

    // Формируем конструктор
    private String name;
    private final boolean isRole;

    public GrantedAuthorityImpl(String name, boolean isRole) {
        this.name = name;
        this.isRole = isRole;
    }

    @Override
    public String getAuthority() {

        if (isRole) {
            name = "ROLE_" + name;
        }

        return name;
    }
}
