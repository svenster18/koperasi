package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.Kursi;
import com.yanti.koperasi.model.Ruangan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RuanganRepository extends CrudRepository<Ruangan, Integer> {
    Ruangan findByNomorRuangan(Integer nomorRuangan);

    List<Ruangan> findByUserIsNull();
}
