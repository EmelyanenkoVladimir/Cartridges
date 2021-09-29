package com.example.springbootsbyt.service;

import com.example.springbootsbyt.model.Cartridges;
import com.example.springbootsbyt.model.History;


import java.util.List;

public interface CartridgeService {

    public Cartridges findById(Integer id);

    public List<Cartridges> findAll();

    public Cartridges saveCartridge(Cartridges cartridge);

    public void deleteById(Integer id);


//    Integer countingById(Cartridges id, Cartridges cartrsIdCartrs, Cartridges count, History status);





}

