package com.yanti.koperasi.model;

import jakarta.persistence.*;

@Entity
public class Ruangan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nomorRuangan;

    @ManyToOne
    @JoinColumn(name = "nomorKTP")
    private User user;

    public Integer getNomorRuangan() {
        return nomorRuangan;
    }

    public void setNomorRuangan(Integer nomorRuangan) {
        this.nomorRuangan = nomorRuangan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
