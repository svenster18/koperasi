package com.yanti.koperasi.model;

import jakarta.persistence.*;

@Entity
public class Pengantaran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer noResi;
    private String alamatTujuan;
    private String alamatPengirim;
    private String noHPTujuan;
    private String noHPPengirim;
    private String deskripsiPaket;

    @ManyToOne
    @JoinColumn(name = "nomorKTP")
    private User user;

    public Pengantaran() {
    }

    public Integer getNoResi() {
        return noResi;
    }

    public void setNoResi(Integer noResi) {
        this.noResi = noResi;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    public String getNoHPTujuan() {
        return noHPTujuan;
    }

    public void setNoHPTujuan(String noHPTujuan) {
        this.noHPTujuan = noHPTujuan;
    }

    public String getNoHPPengirim() {
        return noHPPengirim;
    }

    public void setNoHPPengirim(String noHPPengirim) {
        this.noHPPengirim = noHPPengirim;
    }

    public String getDeskripsiPaket() {
        return deskripsiPaket;
    }

    public void setDeskripsiPaket(String deskripsiPaket) {
        this.deskripsiPaket = deskripsiPaket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
