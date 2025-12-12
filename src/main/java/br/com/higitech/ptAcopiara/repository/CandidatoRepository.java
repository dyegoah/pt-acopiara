package br.com.higitech.ptAcopiara.repository;

import br.com.higitech.ptAcopiara.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    // O Spring cria o SQL automaticamente aqui
}