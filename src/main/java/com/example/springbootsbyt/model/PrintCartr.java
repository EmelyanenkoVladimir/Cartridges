package com.example.springbootsbyt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

//@Data
@Entity
@Table(name = "printcartr")
public class PrintCartr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_cartrs")
    private int idCartrs;

    @Column(name = "id_printers")
    private int idPrinters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCartrs() {
        return idCartrs;
    }

    public void setIdCartrs(int idCartrs) {
        this.idCartrs = idCartrs;
    }

    public int getIdPrinters() {
        return idPrinters;
    }

    public void setIdPrinters(int idPrinters) {
        this.idPrinters = idPrinters;
    }

    public PrintCartr(int id, int idCartrs, int idPrinters) {
        this.id = id;
        this.idCartrs = idCartrs;
        this.idPrinters = idPrinters;
    }

    public PrintCartr() {
    }

    @Override
    public String toString() {
        return "PrintCartr{" +
                "id=" + id +
                ", idCartrs=" + idCartrs +
                ", idPrinters=" + idPrinters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintCartr that = (PrintCartr) o;
        return id == that.id &&
                idCartrs == that.idCartrs &&
                idPrinters == that.idPrinters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCartrs, idPrinters);
    }
}
