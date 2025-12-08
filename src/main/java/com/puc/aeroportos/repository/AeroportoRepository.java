package com.puc.aeroportos.repository;

import com.puc.aeroportos.domain.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
    Optional<Aeroporto> findByCodigoIata(String codigoIata);
}