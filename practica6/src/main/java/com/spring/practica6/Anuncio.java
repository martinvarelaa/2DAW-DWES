package com.spring.practica6;

public class Anuncio {

    private String titulo;
    private String autor;
    private String cuerpo;

    @Override
    public String toString() {
        return "Titulo='" + titulo +
                ", Autor='" + autor +
                ", Cuerpo='" + cuerpo
                ;
    }

    public Anuncio(String titulo, String autor, String cuerpo) {

        this.titulo = titulo;
        this.autor = autor;
        this.cuerpo = cuerpo;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

}
