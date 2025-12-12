package br.com.higitech.ptAcopiara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.higitech.ptAcopiara.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    // Busca ordenando pelas mais recentes primeiro
    List<Noticia> findAllByOrderByDataPublicacaoDesc();
}