package com.yanti.koperasi.model;

import jakarta.persistence.*;

@Entity
public class Kursi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nomorKursi;

    @ManyToOne
    @JoinColumn(name = "nomorKTP")
    private User user;

    public Integer getNomorKursi() {
        return nomorKursi;
    }

    public void setNomorKursi(Integer nomorKursi) {
        this.nomorKursi = nomorKursi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
