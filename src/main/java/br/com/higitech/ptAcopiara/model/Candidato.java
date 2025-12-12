package br.com.higitech.ptAcopiara.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidatos")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo; // majoritaria, vereador, historico
    private Integer ano;
    private String votos;
    
    @Column(columnDefinition = "TEXT")
    private String detalhes; // Texto longo para biografia

    private String fotoUrl; // Aqui salvaremos o link do Cloudinary (https://...)

    // --- Getters e Setters (Obrigatórios) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
    public String getVotos() { return votos; }
    public void setVotos(String votos) { this.votos = votos; }
    public String getDetalhes() { return detalhes; }
    public void setDetalhes(String detalhes) { this.detalhes = detalhes; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}