package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.Pesanan;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface PesananRepository extends CrudRepository<Pesanan, Integer> {
    Iterable<Pesanan> findByUserNomorKTP(String nomorKTP);

    Iterable<Pesanan> findByTanggalPesanan(Date tanggalPesanan);
}
