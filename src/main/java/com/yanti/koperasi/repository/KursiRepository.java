package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.Kursi;
import org.springframework.data.repository.CrudRepository;

public interface KursiRepository extends CrudRepository<Kursi, Integer> {
    Kursi findByNomorKursi(Integer nomorKursi);
}
