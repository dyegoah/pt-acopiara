package br.com.higitech.ptAcopiara.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity; // Se seu Spring for antigo (2.x), use javax.persistence
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "filiados")
public class Filiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nomePai;
    private String nomeMae;
    private String endereco;
    private String bairro;
    private String telefone;
    private String email;
    
    private LocalDateTime dataRegistro;

    // Construtor vazio (obrigatório para JPA)
    public Filiado() {}

    // Executa automaticamente antes de salvar
    @PrePersist
    public void prePersist() {
        this.dataRegistro = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNomePai() { return nomePai; }
    public void setNomePai(String nomePai) { this.nomePai = nomePai; }

    public String getNomeMae() { return nomeMae; }
    public void setNomeMae(String nomeMae) { this.nomeMae = nomeMae; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}