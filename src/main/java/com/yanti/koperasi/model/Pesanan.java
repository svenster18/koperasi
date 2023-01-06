package com.yanti.koperasi.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Pesanan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPesanan;
    private Integer jumlah;
    private Date tanggalPesanan = Date.valueOf(LocalDate.now());

    @ManyToOne
    @JoinColumn(name = "nomorKTP")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idMenu")
    private Menu menu;

    public Pesanan() {
    }

    public Pesanan(Integer idPesanan, Integer jumlah, User user, Menu menu) {
        this.idPesanan = idPesanan;
        this.jumlah = jumlah;
        this.user = user;
        this.menu = menu;
    }

    public Integer getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Date getTanggalPesanan() {
        return tanggalPesanan;
    }

    public void setTanggalPesanan(Date tanggalPesanan) {
        this.tanggalPesanan = tanggalPesanan;
    }
}
