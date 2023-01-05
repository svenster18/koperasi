package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.Pulsa;
import org.springframework.data.repository.CrudRepository;

public interface PulsaRepository extends CrudRepository<Pulsa, Integer> {
    Pulsa findByIdPulsa(Integer idPulsa);
}
