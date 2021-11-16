package com.example.springbootsbyt.repository;

import com.example.springbootsbyt.model.Partylots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyLotsRepository extends JpaRepository<Partylots, Integer> {
    List<Partylots> findAllByLotNumber(String pl);
}
