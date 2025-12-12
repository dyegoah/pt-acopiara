package br.com.higitech.ptAcopiara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.higitech.ptAcopiara.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    // Nenhum método extra por enquanto
}
