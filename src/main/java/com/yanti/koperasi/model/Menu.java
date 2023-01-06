package com.yanti.koperasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMenu;
    private String namaMenu;
    private Integer harga;

    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private Set<Pesanan> pesanan = new HashSet<>();

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Set<Pesanan> getPesanan() {
        return pesanan;
    }

    public void setPesanan(Set<Pesanan> pesanan) {
        this.pesanan = pesanan;
    }
}
