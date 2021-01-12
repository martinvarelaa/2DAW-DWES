package com.spring.practica6;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Usuario {

    private String username;
    private int nAnuncios = 0;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getnAnuncios() {
        return nAnuncios;
    }

    public void setnAnuncios(int nAnuncios) {
        this.nAnuncios = nAnuncios;
    }
}
