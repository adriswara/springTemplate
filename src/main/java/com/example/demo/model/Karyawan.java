package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    private String nik;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getNik() {return nik;}
    public void setNik(String nik) { this.nik = nik;}
}
