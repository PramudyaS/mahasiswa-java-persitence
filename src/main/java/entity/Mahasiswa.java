package entity;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "mahasiswa")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m")
        , @NamedQuery(name = "Mahasiswa.findByNrp", query = "SELECT m FROM Mahasiswa m WHERE m.nrp = :nrp")
        , @NamedQuery(name = "Mahasiswa.findByNama", query = "SELECT m FROM Mahasiswa m WHERE m.nama = :nama")
        , @NamedQuery(name = "Mahasiswa.findByAngkatan", query = "SELECT m FROM Mahasiswa m WHERE m.angkatan = :angkatan")})

public class Mahasiswa implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "nrp")
    private String nrp;

    @Column(name = "nama")
    private String nama;

    @Column(name = "angkatan")
    private String angkatan;

    @Column(name = "sma")
    private String sma;

    public Mahasiswa() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getSma() {
        return sma;
    }

    public void setSma(String sma) {
        this.sma = sma;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }
}
