package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.Kursi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KursiRepository extends CrudRepository<Kursi, Integer> {
    Kursi findByNomorKursi(Integer nomorKursi);

    List<Kursi> findByUserIsNull();
}
