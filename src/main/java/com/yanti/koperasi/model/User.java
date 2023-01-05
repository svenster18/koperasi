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
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "pesanan",
            joinColumns = { @JoinColumn(name = "nomorKTP")},
            inverseJoinColumns = { @JoinColumn(name = "idMenu") }
    )
    private Set<Menu> menus = new HashSet<>();

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

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<Kursi> getKursiSet() {
        return kursiSet;
    }

    public void setKursiSet(Set<Kursi> kursiSet) {
        this.kursiSet = kursiSet;
    }
}
