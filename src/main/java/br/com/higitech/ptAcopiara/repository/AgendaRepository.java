package br.com.higitech.ptAcopiara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.higitech.ptAcopiara.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}