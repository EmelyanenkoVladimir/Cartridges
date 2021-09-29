package com.example.springbootsbyt.model;

import lombok.Data;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.Objects;

//@Data
@Entity
@Table(name = "printers")
public class Printers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrinters;

    @Column(name = "type_printers")
    private String typePrinters;

    public int getIdPrinters() {
        return idPrinters;
    }

    public void setIdPrinters(int idPrinters) {
        this.idPrinters = idPrinters;
    }

    public String getTypePrinters() {
        return typePrinters;
    }

    public void setTypePrinters(String typePrinters) {
        this.typePrinters = typePrinters;
    }

    public Printers(int idPrinters, String typePrinters) {
        this.idPrinters = idPrinters;
        this.typePrinters = typePrinters;
    }

    public Printers() {
    }

    @Override
    public String toString() {
        return "Printers{" +
                "idPrinters=" + idPrinters +
                ", typePrinters='" + typePrinters + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printers printers = (Printers) o;
        return idPrinters == printers.idPrinters &&
                Objects.equals(typePrinters, printers.typePrinters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrinters, typePrinters);
    }
}
