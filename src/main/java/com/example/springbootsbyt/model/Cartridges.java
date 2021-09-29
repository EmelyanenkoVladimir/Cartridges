package com.example.springbootsbyt.model;

//import com.example.springbootsbyt.entity.Cartrs;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//@Data
@Entity
@Table(name = "cartridges")
public class Cartridges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inventory_number")
    private Integer inventoryNumber;

    @Column(name = "resource")
    private Integer resource;

    @Column(name = "barcode")
    private Integer barcode;

    @Column(name = "comments")
    private String comments;

    @Column(name = "city")
    private String city;

    @Column(name = "executor")
    private String executor;

    @Column(name = "count")
    private Integer count;

    @Column(name = "cartrs_id_cartrs")
    private Integer cartrsIdCartrs;

    @Column(name = "printers_id_printers")
    private Integer printersIdPrinters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Integer inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCartrsIdCartrs() {
        return cartrsIdCartrs;
    }

    public void setCartrsIdCartrs(Integer cartrsIdCartrs) {
        this.cartrsIdCartrs = cartrsIdCartrs;
    }

    public Integer getPrintersIdPrinters() {
        return printersIdPrinters;
    }

    public void setPrintersIdPrinters(Integer printersIdPrinters) {
        this.printersIdPrinters = printersIdPrinters;
    }

    public Cartridges(Integer id, Integer inventoryNumber, Integer resource, Integer barcode,
                      String comments, String city, String executor, Integer count,
                      Integer cartrsIdCartrs, Integer printersIdPrinters) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.resource = resource;
        this.barcode = barcode;
        this.comments = comments;
        this.city = city;
        this.executor = executor;
        this.count = count;
        this.cartrsIdCartrs = cartrsIdCartrs;
        this.printersIdPrinters = printersIdPrinters;
    }

    public Cartridges() {
    }

    @Override
    public String toString() {
        return "Cartridges{" +
                "id=" + id +
                ", inventoryNumber=" + inventoryNumber +
                ", resource=" + resource +
                ", barcode=" + barcode +
                ", comments='" + comments + '\'' +
                ", city='" + city + '\'' +
                ", executor='" + executor + '\'' +
                ", count='" + count + '\'' +
                ", cartrsIdCartrs=" + cartrsIdCartrs +
                ", printersIdPrinters=" + printersIdPrinters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartridges that = (Cartridges) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(inventoryNumber, that.inventoryNumber) &&
                Objects.equals(resource, that.resource) &&
                Objects.equals(barcode, that.barcode) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(city, that.city) &&
                Objects.equals(executor, that.executor) &&
                Objects.equals(count, that.count) &&
                Objects.equals(cartrsIdCartrs, that.cartrsIdCartrs) &&
                Objects.equals(printersIdPrinters, that.printersIdPrinters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventoryNumber, resource, barcode, comments, city,
                executor, count, cartrsIdCartrs, printersIdPrinters);
    }
}
