package br.com.higitech.ptAcopiara.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.higitech.ptAcopiara.model.Filiado;

@Repository
public interface FiliadoRepository extends JpaRepository<Filiado, Long> {

    // Query personalizada para buscar o termo em Nome, Email, Bairro, Pai ou Mãe
    // O LOWER() garante que a busca funcione independente de Maiúsculas/minúsculas
    @Query("SELECT f FROM Filiado f WHERE " +
           "LOWER(f.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(f.email) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(f.bairro) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(f.nomeMae) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(f.nomePai) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Filiado> buscarPorQualquerCampo(@Param("termo") String termo);
    
    // Ordena por decrescente para os mais novos aparecerem primeiro
    List<Filiado> findAllByOrderByIdDesc();
}