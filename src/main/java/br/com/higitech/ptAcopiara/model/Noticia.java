package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    
    @Column(length = 5000) // Permite textos longos
    private String conteudo;
    
    private String categoria; // Ex: "Mulheres", "Jovens", "Geral"
    
    private LocalDate dataPublicacao;
    
    private String fotoUrl;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public LocalDate getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}