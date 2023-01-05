package com.yanti.koperasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Pulsa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPulsa;
    private Integer nominal;
    private Integer harga;

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "pembelian",
            joinColumns = { @JoinColumn(name = "idPulsa")},
            inverseJoinColumns = { @JoinColumn(name = "nomorKTP") }
    )
    private Set<User> users = new HashSet<>();

    public Integer getIdPulsa() {
        return idPulsa;
    }

    public void setIdPulsa(Integer idPulsa) {
        this.idPulsa = idPulsa;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
