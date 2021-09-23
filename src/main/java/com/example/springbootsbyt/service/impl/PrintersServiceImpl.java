package com.example.springbootsbyt.service.impl;

import com.example.springbootsbyt.model.Printers;
import com.example.springbootsbyt.repository.PrintersRepository;
import com.example.springbootsbyt.service.PrintersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrintersServiceImpl implements PrintersService {


    private final PrintersRepository printersRepository;
    @Autowired
    public PrintersServiceImpl(PrintersRepository printersRepository) {
        this.printersRepository = printersRepository;
    }

    @Override
    public Printers findById(Integer id) {
        return printersRepository.findById(id).orElse(null);
    }

    @Override
    public List<Printers> findAll() {
        return printersRepository.findAll();
    }

    @Override
    public Printers savePrinters(Printers printers) {
        return printersRepository.save(printers);
    }

    @Override
    public void deleteById(Integer id) {
        printersRepository.deleteById(id);
    }
}
