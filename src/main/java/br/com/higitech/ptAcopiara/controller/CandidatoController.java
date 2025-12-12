package br.com.higitech.ptAcopiara.controller;

import br.com.higitech.ptAcopiara.model.Candidato;
import br.com.higitech.ptAcopiara.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository repository;

    // 1. LISTAR TODOS (Carrega a tabela quando abre a página)
    @GetMapping
    public List<Candidato> listarTodos() {
        // Ordena por ano decrescente (mais recente primeiro)
        return repository.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.DESC, "ano"));
    }

    // 2. SALVAR ou ATUALIZAR (Recebe o JSON com a URL da foto e salva no Postgres)
    @PostMapping
    public Candidato salvar(@RequestBody Candidato candidato) {
        return repository.save(candidato);
    }

    // 3. DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}