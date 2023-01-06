package com.yanti.koperasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    private String nomorKTP;
    private String namaLengkap;
    private String nomorHandphone;
    private String username;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Pesanan> pesanan = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Kursi> kursiSet = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Pulsa> setPulsa = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "user")
    private Set<Ruangan> ruanganSet = new HashSet<>();

    public User() {}

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNomorHandphone() {
        return nomorHandphone;
    }

    public void setNomorHandphone(String nomorHandphone) {
        this.nomorHandphone = nomorHandphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Kursi> getKursiSet() {
        return kursiSet;
    }

    public void setKursiSet(Set<Kursi> kursiSet) {
        this.kursiSet = kursiSet;
    }

    public Set<Pesanan> getPesanan() {
        return pesanan;
    }

    public void setPesanan(Set<Pesanan> pesanan) {
        this.pesanan = pesanan;
    }

    public Set<Pulsa> getSetPulsa() {
        return setPulsa;
    }

    public void setSetPulsa(Set<Pulsa> setPulsa) {
        this.setPulsa = setPulsa;
    }

    public Set<Ruangan> getRuanganSet() {
        return ruanganSet;
    }

    public void setRuanganSet(Set<Ruangan> ruanganSet) {
        this.ruanganSet = ruanganSet;
    }
}
