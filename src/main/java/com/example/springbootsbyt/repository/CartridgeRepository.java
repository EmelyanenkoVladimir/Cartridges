package com.example.springbootsbyt.repository;

import com.example.springbootsbyt.model.Cartridges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CartridgeRepository extends JpaRepository<Cartridges, Long> {
    @Query(value = "SELECT * from cartridges as c left join cartrs as ca on c.cartrs_id_cartrs = ca.id_cartrs" +
            " left join printers as p on ca.printers_id_printers=p.id_printers left join history as h on c.id = h.cartridges_id" +
            " where  c.city like :keyword or c.inventory_number like :keyword or c.count like :keyword" +
            " or ca.type_cartr like :keyword or h.status like :keyword" +
            " or p.type_printers like :keyword", nativeQuery = true)
    List<Cartridges> findAll(@Param("keyword") String keyword);

    List<Cartridges> findAllByInventoryNumber(String barcode);

    Cartridges findByInventoryNumber(String inv);

    @Query(value = "select * from cartridges as c left join partylots as p on c.id = p.cartridges_id left join history as h on h.id_history = p.history_id_history where p.party_status = 3 and h.date_of_status between ? and ?", nativeQuery = true)
    List<Cartridges> findAllByPartyStatus(@Param("date1") Date dt1,@Param("date2") Date dt2);

}