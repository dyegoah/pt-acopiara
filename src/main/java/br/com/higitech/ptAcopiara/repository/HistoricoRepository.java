package br.com.higitech.ptAcopiara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.higitech.ptAcopiara.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}