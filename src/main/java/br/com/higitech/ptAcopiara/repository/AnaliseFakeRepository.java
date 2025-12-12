package br.com.higitech.ptAcopiara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.higitech.ptAcopiara.model.AnaliseFake;

@Repository
public interface AnaliseFakeRepository extends JpaRepository<AnaliseFake, Long> {
    
    @Query("SELECT COUNT(a) FROM AnaliseFake a")
    long totalAnalisado();

    @Query("SELECT COUNT(a) FROM AnaliseFake a WHERE a.isFake = true")
    long totalFakes();

    @Query("SELECT COUNT(a) FROM AnaliseFake a WHERE a.isFake = false")
    long totalVerdadeiros();
}