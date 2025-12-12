package br.com.higitech.ptAcopiara.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "analises_fake")
public class AnaliseFake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isFake;
    private LocalDateTime dataAnalise;
    private String nomeArquivo;

    @PrePersist
    public void prePersist() {
        this.dataAnalise = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean isFake() { return isFake; }
    public void setFake(boolean fake) { isFake = fake; }
    public LocalDateTime getDataAnalise() { return dataAnalise; }
    public String getNomeArquivo() { return nomeArquivo; }
    public void setNomeArquivo(String nomeArquivo) { this.nomeArquivo = nomeArquivo; }
}