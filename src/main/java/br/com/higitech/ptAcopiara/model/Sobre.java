package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.*;

@Entity
public class Sobre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(length = 5000) // Permite textos longos
    private String texto;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
}