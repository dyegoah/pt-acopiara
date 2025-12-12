package br.com.higitech.ptAcopiara.repository;

import br.com.higitech.ptAcopiara.model.SiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteConfigRepository extends JpaRepository<SiteConfig, Long> {
    // O Spring implementa tudo sozinho em tempo de execução
}